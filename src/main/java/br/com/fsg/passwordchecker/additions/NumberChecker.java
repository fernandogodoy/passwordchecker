package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Fernando-Godoy
 *
 */

@Component
public class NumberChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(4);

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();

		var numberSize = BigDecimal.valueOf(checker.countNumbers());
		return checker.hasLetters() ? (numberSize.multiply(OPERATOR)) : BigDecimal.ZERO;
	}

}
