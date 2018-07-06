package br.com.fsg.passwordchecker.deduction;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SequentialSymbolsCheckerTest {

	Deduction checker;

	@Before
	public void init() {
		checker = new SequentialSymbolsChecker();
	}

	@Test
	public void onlyLetterTest() {
		var result = checker.verify("abCdEf");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	public void oneNumberTest() {
		var result = checker.verify("1");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	public void numbersTest() {
		var result = checker.verify("123456789");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	public void oneNumberAndOneLetterTest() {
		var result = checker.verify("a1");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	public void numberAndLettersTest() {
		var result = checker.verify("a1B2c3D4e5F6g7I8j9");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	public void cedilhaAndLetter() {
		var result = checker.verify("ça");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	@Ignore
	public void specialCharsTest() {
		var result = checker.verify("!@#/$¨*+@#$%¨*");
		assertThat(BigDecimal.valueOf(9), equalTo(result));
	}

	@Test
	public void letterUpperConsecutive() {
		var result = checker.verify("AAAAAA");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

	@Test
	public void letterLowerConsecutive() {
		var result = checker.verify("aaaaa");
		assertThat(BigDecimal.ZERO, equalTo(result));
	}

}
