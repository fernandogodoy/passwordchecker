package br.com.fsg.passwordchecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fsg.passwordchecker.dto.PasswordChecherRequest;
import br.com.fsg.passwordchecker.dto.PasswordCheckerResponse;
import br.com.fsg.passwordchecker.service.PasswordCheckerService;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PasswordCheckerController {

	@Autowired
	private PasswordCheckerService service;

	@PostMapping("/api/v1/password/check")
	public PasswordCheckerResponse checker(@RequestBody PasswordChecherRequest requestDTO) {
		return service.check(requestDTO.getPassword());
	}

}
