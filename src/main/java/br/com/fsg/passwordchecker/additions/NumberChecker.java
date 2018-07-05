package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */

public class NumberChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(4);

	@Override
	protected BigDecimal rate() {
		var numberSize = BigDecimal.valueOf(countNumbers());
		return hasLetters() ? (numberSize.multiply(OPERATOR)) : BigDecimal.ZERO;
	}

}
