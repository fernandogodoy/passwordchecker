package br.com.fsg.passwordchecker.util;

import java.util.List;
import java.util.regex.Pattern;

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
		return List.of(password.split(EMPTY)).stream()
				.filter(pattern.asPredicate())
				.count();
	}

}
