package br.com.fsg.passwordchecker.util;

import static org.apache.commons.lang3.StringUtils.equalsAny;
import static org.apache.commons.lang3.StringUtils.isAllLowerCase;
import static org.apache.commons.lang3.StringUtils.isAllUpperCase;
import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.isNumeric;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class CheckerUtil {

	private static final String EMPTY = "";

	private String password;

	public CheckerUtil(String password) {
		this.password = password;
	}

	public int getPasswordLength() {
		return password.length();
	}

	public boolean hasUpperLetters() {
		return countUpperLetters() > 0;
	}

	public long countUpperLetters() {
		return counterByPattern(PatternUtil.UPPER_PATTERN);
	}

	public boolean hasLowerLetters() {
		return countLowerLetters() > 0;
	}

	public boolean hasNumber() {
		return countNumbers() > 0;
	}

	public boolean hasSymbol() {
		return countSymbols() > 0;
	}

	public boolean hastOnlyLetters() {
		return countOnlyLetters() > 0;
	}

	public long countOnlyLetters() {
		return countLowerLetters() + countUpperLetters();
	}

	public long countLowerLetters() {
		return counterByPattern(PatternUtil.LOWER_PATTERN);
	}

	public long countNotLetters() {
		return counterByPattern(PatternUtil.LETTERS);
	}

	public boolean hasLetters() {
		return hasLowerLetters() || hasUpperLetters();
	}

	public long countSymbols() {
		return counterByPattern(PatternUtil.NOT_SPECIAL_CHARS_PATTERN);
	}

	public long countNumbers() {
		return counterByPattern(PatternUtil.NUMBER_PATTERN);
	}

	private long counterByPattern(Pattern pattern) {
		return passwordToList().stream()
				.filter(pattern.asPredicate())
				.count();
	}

	private List<String> passwordToList() {
		return List.of(password.split(EMPTY));
	}

	public BigDecimal countRepeat() {
		var grouped = passwordToList().stream()
				.map(String::toLowerCase)
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		return grouped.entrySet().stream()
				.filter(val -> val.getValue() > 1)
				.map(Map.Entry::getValue)
				.map(BigDecimal::valueOf)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	public BigDecimal countUpperConsecutive() {
		AtomicInteger counter = new AtomicInteger(0);
		var lastIndex = passwordToList().size();
		IntStream.range(0, password.length()).forEach(index -> {
			if ((index + 1) < lastIndex) {
				var char1 = passwordToList().get(index);
				var char2 = passwordToList().get(index + 1);
				boolean isUpper = isAllUpperCase(char1) && StringUtils.isAllUpperCase(char2);
				if (isUpper && StringUtils.equals(char1, char2)) {
					counter.set(counter.get() + 1);
				}
			}
		});
		return BigDecimal.valueOf(counter.get());
	}

	public BigDecimal countLowerConsecutive() {
		AtomicInteger counter = new AtomicInteger(0);
		var lastIndex = passwordToList().size();
		IntStream.range(0, password.length()).forEach(index -> {
			if ((index + 1) < lastIndex) {
				var char1 = passwordToList().get(index);
				var char2 = passwordToList().get(index + 1);
				boolean isUpper = isAllLowerCase(char1) && isAllLowerCase(char2);
				if (isUpper && StringUtils.equals(char1, char2)) {
					counter.set(counter.get() + 1);
				}
			}
		});
		return BigDecimal.valueOf(counter.get());
	}

	public BigDecimal countNumbersConsecutive() {
		AtomicInteger counter = new AtomicInteger(0);
		var lastIndex = passwordToList().size();
		IntStream.range(0, password.length()).forEach(index -> {
			if ((index + 1) < lastIndex) {
				var char1 = passwordToList().get(index);
				var char2 = passwordToList().get(index + 1);
				boolean isDigit = isNumeric(char1) && isNumeric(char2);
				if (isDigit) {
					counter.set(counter.get() + 1);
				}
			}
		});
		return BigDecimal.valueOf(counter.get());
	}

	public BigDecimal countSequentialLetters() {
		AtomicInteger counter = new AtomicInteger(0);
		var lastIndex = passwordToList().size();
		IntStream.range(0, password.length()).forEach(index -> {
			if ((index + 2) < lastIndex) {
				var char1 = passwordToList().get(index);
				var char2 = passwordToList().get(index + 1);
				var char3 = passwordToList().get(index + 2);
				boolean isAlpha = isAlpha(char1) && isAlpha(char2) && isAlpha(char3);
				if (isAlpha && !equalsAny(char1, char2, char3)) {
					counter.set(counter.get() + 1);
				}
			}
		});
		return BigDecimal.valueOf(counter.get());
	}

	public BigDecimal countSequentialNumbers() {
		AtomicInteger counter = new AtomicInteger(0);
		var lastIndex = passwordToList().size();
		IntStream.range(0, password.length()).forEach(index -> {
			if ((index + 2) < lastIndex) {
				var char1 = passwordToList().get(index);
				var char2 = passwordToList().get(index + 1);
				var char3 = passwordToList().get(index + 2);
				boolean isNumeric = isNumeric(char1) && isNumeric(char2) && isNumeric(char3);
				if (isNumeric && !equalsAny(char1, char2, char3)) {
					counter.set(counter.get() + 1);
				}
			}
		});
		return BigDecimal.valueOf(counter.get());
	}

	public BigDecimal countSequentialSymbols() {
		AtomicInteger counter = new AtomicInteger(0);
		var lastIndex = passwordToList().size();
		IntStream.range(0, password.length()).forEach(index -> {
			if ((index + 2) < lastIndex) {
				var char1 = passwordToList().get(index);
				var char2 = passwordToList().get(index + 1);
				var char3 = passwordToList().get(index + 2);
				long count = countByPattern(PatternUtil.NOT_SPECIAL_CHARS_PATTERN, char1, char2, char3);
				boolean isSymbol = count > 0;
				if (isSymbol && !equalsAny(char1, char2, char3)) {
					counter.set(counter.get() + 1);
				}
			}
		});
		return BigDecimal.valueOf(counter.get());
	}

	private long countByPattern(Pattern patter,  String... array) {
		return List.of(array).stream()
				.filter(patter.asPredicate())
				.count();
	}

}
