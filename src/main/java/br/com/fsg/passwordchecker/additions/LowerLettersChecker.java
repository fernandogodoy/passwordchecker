package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@Component
public class LowerLettersChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(2);

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();
		var passwordSize = BigDecimal.valueOf(checker.getPasswordLength());
		var lowerSize = BigDecimal.valueOf(checker.countLowerLetters());
		return checker.hasLowerLetters() ? (passwordSize.subtract(lowerSize)).multiply(OPERATOR) : BigDecimal.ZERO;
	}

}
