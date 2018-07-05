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
		BigDecimal lowerSize = BigDecimal.ZERO;
		BigDecimal upperSize = BigDecimal.ZERO;
		BigDecimal numbersSize = BigDecimal.ZERO;
		BigDecimal symbolsSize = BigDecimal.ZERO;

		if (hasLowerLetters()) {
			lowerSize = BigDecimal.valueOf(countLowerLetters());
		}
		if (hasUpperLetters()) {
			upperSize = BigDecimal.valueOf(countLowerLetters());
		}
		if (hasNumber()) {
			numbersSize = BigDecimal.valueOf(countNumbers());
		}

		if (hasSymbol()) {
			symbolsSize = BigDecimal.valueOf(countSymbols());
		}

		return getPasswordLength() > 8 ? (lowerSize.add(upperSize).add(numbersSize).add(symbolsSize)).multiply(OPERATOR)
				: BigDecimal.ZERO;
	}

}
