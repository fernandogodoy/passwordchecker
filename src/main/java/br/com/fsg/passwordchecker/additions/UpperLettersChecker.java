package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@Component
public class UpperLettersChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(2);

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();

		var passwordSize = BigDecimal.valueOf(checker.getPasswordLength());
		var upperSize = BigDecimal.valueOf(checker.countUpperLetters());
		return checker.hasUpperLetters() ? (passwordSize.subtract(upperSize)).multiply(OPERATOR) : BigDecimal.ZERO;
	}

}
