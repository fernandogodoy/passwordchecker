package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@Component
public class MiddleNumbersOrSymbolsChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(2);

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();

		var passwordLength = BigDecimal.valueOf(checker.getPasswordLength());
		var notLetterSize = BigDecimal.valueOf(checker.countNotLetters());
		return passwordLength.intValue() > 2 ? (passwordLength.subtract(notLetterSize)).multiply(OPERATOR)
				: BigDecimal.ZERO;
	}

}
