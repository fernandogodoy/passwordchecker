package br.com.fsg.passwordchecker.deduction;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class RepeatCharactersChecker extends AbstractDeduction {

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();
		return checker.countRepeat();
	}

}
