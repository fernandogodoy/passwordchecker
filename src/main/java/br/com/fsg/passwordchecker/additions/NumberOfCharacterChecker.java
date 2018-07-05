package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class NumberCharacterChecker extends AbstractAdditionChecker {

	private static final int OPERATOR = 4;

	@Override
	protected BigDecimal rate() {
		return BigDecimal.valueOf(getPasswordLength() * OPERATOR);
	}

}
