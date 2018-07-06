package br.com.fsg.passwordchecker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordmeterController {

	@Autowired
	private Factory factory;
	
	@GetMapping("/api/v1/passwordcker/{password}")
	public String checker() {
		 factory.additionFactory();
	}
	
}
