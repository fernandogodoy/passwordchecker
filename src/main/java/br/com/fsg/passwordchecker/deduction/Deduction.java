package br.com.fsg.passwordchecker.deduction;

import java.math.BigDecimal;

/**
 * Check a password and subtract a bonus when the restrictions are correct
 * 
 * @author Fernando-Godoy
 *
 */
public interface Deduction {

	BigDecimal verify(String password);

}
