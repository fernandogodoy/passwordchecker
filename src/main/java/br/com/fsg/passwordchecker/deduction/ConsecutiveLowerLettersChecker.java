package br.com.fsg.passwordchecker.deduction;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class ConsecutiveLowerLettersChecker extends AbstractDeduction {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(2);

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();
		return checker.countLowerConsecutive().multiply(OPERATOR);
	}

}
