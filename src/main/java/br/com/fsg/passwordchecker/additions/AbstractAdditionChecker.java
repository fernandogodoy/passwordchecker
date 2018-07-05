package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public abstract class AbstractAdditionChecker implements AdditionChecker {

	private static final Pattern LOWER_PATTERN = Pattern.compile("[a-z]+");
	private static final Pattern UPPER_PATTERN = Pattern.compile("[A-Z]+");
	private static final Pattern NOT_SPECIAL_CHARS_PATTERN = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

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
		return counterByPattern(UPPER_PATTERN);
	}

	public boolean hasLowerLetters() {
		return countLowerLetters() > 0;
	}

	public long countLowerLetters() {
		return counterByPattern(LOWER_PATTERN);
	}

	public boolean hasLetters() {
		return hasLowerLetters() || hasUpperLetters();
	}

	public long countSymbols() {
		return counterByPattern(NOT_SPECIAL_CHARS_PATTERN);
	}

	public long countNumbers() {
		return counterByPattern(NUMBER_PATTERN);
	}
	
	private long counterByPattern(Pattern pattern) {
		 return List.of(password.split(EMPTY)).stream()
			.filter(pattern.asPredicate())
			.count();
	}

}
