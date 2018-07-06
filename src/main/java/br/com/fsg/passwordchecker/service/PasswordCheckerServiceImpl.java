package br.com.fsg.passwordchecker.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fsg.passwordchecker.dto.PasswordCheckerResponse;
import br.com.fsg.passwordchecker.enumerator.LevelScore;
import br.com.fsg.passwordchecker.factory.Factory;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@Service
public class PasswordCheckerServiceImpl implements PasswordCheckerService {

	@Autowired
	private Factory factory;

	public PasswordCheckerResponse check(final String password) {
		var rate = getAdditionVal(password).subtract(getDeductionVal(password));
		var level = LevelScore.byScore(rate);
		return new PasswordCheckerResponse(rate, level);
	}

	private BigDecimal getAdditionVal(final String password) {
		return factory.additionsFactory().stream()
				.map(addition -> addition.verify(password))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private BigDecimal getDeductionVal(final String password) {
		return factory.deductionsFactory().stream()
				.map(addition -> addition.verify(password))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
