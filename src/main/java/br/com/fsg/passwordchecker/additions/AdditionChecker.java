package br.com.fsg.passwordchecker.additions;

import java.math.BigDecimal;

/**
 * Check a password and add a bonus when the restrictions are correct
 * 
 * @author Fernando-Godoy
 *
 */
public interface AdditionChecker {

	BigDecimal verify(String password);

}
