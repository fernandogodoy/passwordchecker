package br.com.fsg.passwordchecker.util;

import java.util.regex.Pattern;

/**
 * 
 * @author Fernando-Godóy
 *
 */
public class PatternUtil {

	public static final Pattern LOWER_PATTERN = Pattern.compile("[a-z]+");
	public static final Pattern UPPER_PATTERN = Pattern.compile("[A-Z]+");
	public static final Pattern NOT_SPECIAL_CHARS_PATTERN = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
	public static final Pattern LETTERS = Pattern.compile("[A-z]");
}
