package br.com.fsg.passwordchecker.util;

import java.math.BigDecimal;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public interface Meter {

	BigDecimal verify(String password);

}
