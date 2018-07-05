package br.com.fsg.passwordchecker.additions;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class LowercaseLettersCheckerTest {

	private AdditionChecker checker;

	@Before
	public void init() {
		checker = new LowercaseLettersChecker();
	}

	@Test
	public void onlyLetterTest() {
		var result = checker.verify("abCdEf");
		assertThat(BigDecimal.valueOf(4), equalTo(result));
	}

	@Test
	public void oneNumberTest() {
		var result = checker.verify("1");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	public void oneNumbersTest() {
		var result = checker.verify("123456789");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	public void oneNumberAndOneLetterTest() {
		var result = checker.verify("a1");
		assertThat(BigDecimal.valueOf(2), equalTo(result));
	}

	@Test
	public void numberAndLettersTest() {
		var result = checker.verify("a1B2c3D4e5F6g7I8j9");
		assertThat(BigDecimal.valueOf(26), equalTo(result));
	}

	@Test
	public void numberAndLettersAndEspecialCharsTest() {
		var result = checker.verify("a1B2c3D4e5F6g7I8j9@*-+.*/ç^;?0");
		assertThat(BigDecimal.valueOf(50), equalTo(result));
	}

}
