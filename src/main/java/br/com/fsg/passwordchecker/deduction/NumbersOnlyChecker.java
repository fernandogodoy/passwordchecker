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
		var onlyLettersSize = BigDecimal.valueOf(checker.countOnlyLetters());
		return checker.hasNumber() || checker.hasSymbol() ? BigDecimal.ZERO : onlyLettersSize;
	}

}
