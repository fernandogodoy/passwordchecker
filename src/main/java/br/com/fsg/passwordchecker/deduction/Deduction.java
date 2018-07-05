package br.com.fsg.passwordchecker.deduction;

/**
 * Check a password and subtract a bonus when the restrictions are correct
 * 
 * @author Fernando-Godoy
 *
 */
public interface Deduction {

	Long verify(String password);

}
