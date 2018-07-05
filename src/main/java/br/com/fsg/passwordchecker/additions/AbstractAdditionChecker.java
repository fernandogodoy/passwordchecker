package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public abstract class AbstractAdditionChecker implements AdditionChecker {

	private static final int FIRST = 0;

	private static final String NOT_NUMBER_PATTERN = "[^0-9]+";
	private static final Pattern NOT_SPECIAL_CHARS_PATTERN = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);

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
		return List.of(password.split(EMPTY)).stream()
				.filter(letter -> Character.isUpperCase(letter.charAt(FIRST)))
				.count();
	}
	
	public boolean hasLowerLetters() {
		return countLowerLetters() > 0;
	}
	

	public long countLowerLetters() {
		return List.of(password.split(EMPTY)).stream()
				.filter(letter -> Character.isLowerCase(letter.charAt(FIRST)))
				.count();
	}

	public int countSpecialChars() {
		Matcher matcher = NOT_SPECIAL_CHARS_PATTERN.matcher(password);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}

	public int countNumbers() {
		return password.replaceAll(NOT_NUMBER_PATTERN, EMPTY).length();
	}

}
