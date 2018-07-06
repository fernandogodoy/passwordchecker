package br.com.fsg.passwordchecker.service;

import br.com.fsg.passwordchecker.dto.PasswordCheckerResponse;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public interface PasswordCheckerService {

	PasswordCheckerResponse check(String password);
}
