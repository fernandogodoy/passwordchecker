package br.com.fsg.passwordchecker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PasswordmeterController.class })
public class PasswordmeterControllerTest {

	private MockMvc mvc;

	@Before
	public void init() {
		mvc = MockMvcBuilders.standaloneSetup(this).build();
	}

	@Test
	public void test() throws Exception {
		mvc.perform(get("/api/v1/passwordcker/{password}", "abc123ABC"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
