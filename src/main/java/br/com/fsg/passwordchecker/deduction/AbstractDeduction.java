package br.com.fsg.passwordchecker.deduction;

import java.math.BigDecimal;

import br.com.fsg.passwordchecker.util.CheckerUtil;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public abstract class AbstractDeduction implements Deduction {

	private String password;

	protected abstract BigDecimal rate();

	@Override
	public BigDecimal verify(String password) {
		this.password = password;
		return rate();
	}

	protected CheckerUtil getChecker() {
		return new CheckerUtil(password);
	}

}
