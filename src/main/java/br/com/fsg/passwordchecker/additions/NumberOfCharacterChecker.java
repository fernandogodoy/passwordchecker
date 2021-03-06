package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@Component
public class NumberOfCharacterChecker extends AbstractAdditionChecker {

	private static final int OPERATOR = 4;

	@Override
	protected BigDecimal rate() {
		var checker = getChecker();
		
		return BigDecimal.valueOf(checker.getPasswordLength() * OPERATOR);
	}

}
