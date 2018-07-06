package br.com.fsg.passwordchecker.deduction;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class NumbersOnlyChecker extends AbstractDeduction {

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();
		var onlyNumbersSize = BigDecimal.valueOf(checker.countNumbers());
		return checker.hastOnlyLetters()? BigDecimal.ZERO : onlyNumbersSize;
	}

}
