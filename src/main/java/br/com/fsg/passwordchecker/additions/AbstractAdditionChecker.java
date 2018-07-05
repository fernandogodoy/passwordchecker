package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

import br.com.fsg.passwordchecker.deduction.PatternUtil;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public abstract class AbstractAdditionChecker implements AdditionChecker {

	private static final String EMPTY = "";

	private String password;

	protected abstract BigDecimal rate();

	@Override
	public BigDecimal verify(String password) {
		this.password = password;
		return rate();
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

	public long countLowerLetters() {
		return counterByPattern(PatternUtil.LOWER_PATTERN);
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
		return List.of(password.split(EMPTY)).stream()
				.filter(pattern.asPredicate())
				.count();
	}

}
