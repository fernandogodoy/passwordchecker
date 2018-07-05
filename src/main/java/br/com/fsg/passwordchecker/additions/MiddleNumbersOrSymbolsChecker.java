package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class MiddleNumbersOrSymbolsChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(2);

	@Override
	protected BigDecimal rate() {
		BigDecimal passwordLength = BigDecimal.valueOf(getPasswordLength());
		BigDecimal notLetterSize = BigDecimal.valueOf(countNotLetters());
		return passwordLength.intValue() > 2 ? (passwordLength.subtract(notLetterSize)).multiply(OPERATOR)
				: BigDecimal.ZERO;
	}

}
