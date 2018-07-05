package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class LowerLettersChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(2);

	@Override
	protected BigDecimal rate() {
		var passwordSize = BigDecimal.valueOf(getPasswordLength());
		var lowerSize = BigDecimal.valueOf(countLowerLetters());	
		return hasLowerLetters() ? (passwordSize.subtract(lowerSize)).multiply(OPERATOR) : BigDecimal.ZERO;
	}

}
