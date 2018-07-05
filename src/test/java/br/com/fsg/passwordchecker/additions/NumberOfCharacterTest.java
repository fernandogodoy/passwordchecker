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
public class NumberOfCharacterTest {

	private AdditionChecker checker;

	@Before
	public void init() {
		checker = new NumberOfCharacterChecker();
	}

	@Test
	public void onlyLetterTest() {
		var result = checker.verify("abcdef");
		assertThat(BigDecimal.valueOf(24), equalTo(result));
	}

	@Test
	public void oneNumberTest() {
		var result = checker.verify("1");
		assertThat(BigDecimal.valueOf(4), equalTo(result));
	}

	@Test
	public void oneNumbersTest() {
		var result = checker.verify("123456789");
		assertThat(BigDecimal.valueOf(36), equalTo(result));
	}

	@Test
	public void oneNumberAndOneLetterTest() {
		var result = checker.verify("a1");
		assertThat(BigDecimal.valueOf(8), equalTo(result));
	}

	@Test
	public void numberAndLettersTest() {
		var result = checker.verify("a1b2c3d4e5f6g7i8j9");
		assertThat(BigDecimal.valueOf(72), equalTo(result));
	}
	
	@Test
	public void numberAndLettersAndSpecialCharsTest() {
		var result = checker.verify("a1b2c3d4e5f6g7i8j9@*-+.*/ç^;?0");
		assertThat(BigDecimal.valueOf(120), equalTo(result));
	}
}
