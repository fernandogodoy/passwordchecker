package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

import br.com.fsg.passwordchecker.util.CheckerUtil;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public abstract class AbstractAdditionChecker implements AdditionChecker {

	private String password;

	protected abstract BigDecimal rate();

	@Override
	public BigDecimal verify(String password) {
		this.password = password.trim();
		return rate();
	}

	protected CheckerUtil getChecker() {
		return new CheckerUtil(password);
	}

}
