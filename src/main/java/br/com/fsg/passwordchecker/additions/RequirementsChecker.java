package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class RequirementsChecker extends AbstractAdditionChecker {

	private static final BigDecimal OPERATOR = BigDecimal.valueOf(2);

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();
		var lowerSize = BigDecimal.ZERO;
		var upperSize = BigDecimal.ZERO;
		var numbersSize = BigDecimal.ZERO;
		var symbolsSize = BigDecimal.ZERO;

		if (checker.hasLowerLetters()) {
			lowerSize = BigDecimal.valueOf(checker.countLowerLetters());
		}
		if (checker.hasUpperLetters()) {
			upperSize = BigDecimal.valueOf(checker.countLowerLetters());
		}
		if (checker.hasNumber()) {
			numbersSize = BigDecimal.valueOf(checker.countNumbers());
		}

		if (checker.hasSymbol()) {
			symbolsSize = BigDecimal.valueOf(checker.countSymbols());
		}

		return checker.getPasswordLength() > 8
				? (lowerSize.add(upperSize).add(numbersSize).add(symbolsSize)).multiply(OPERATOR)
				: BigDecimal.ZERO;
	}

}
