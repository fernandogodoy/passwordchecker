package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */

public class SymbolChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(6);

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();

		var numberSize = BigDecimal.valueOf(checker.countSymbols());
		return (numberSize.multiply(OPERATOR));
	}

}
