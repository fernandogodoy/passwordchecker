package br.com.fsg.passwordchecker.deduction;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class SequentialNumbersChecker extends AbstractDeduction {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(3);

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();
		return checker.countSequentialNumbers().multiply(OPERATOR);
	}

}
