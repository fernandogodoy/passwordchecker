package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class UpperLettersChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(2);

	@Override
	protected BigDecimal rate() {
		var passwordSize = BigDecimal.valueOf(getPasswordLength());
		var upperSize = BigDecimal.valueOf(countUpperLetters());	
		return hasUpperLetters() ? (passwordSize.subtract(upperSize)).multiply(OPERATOR) : BigDecimal.ZERO;
	}

}
