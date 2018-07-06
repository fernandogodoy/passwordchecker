package br.com.fsg.passwordchecker.dto;

import java.math.BigDecimal;

import br.com.fsg.passwordchecker.enumerator.LevelScore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 
 * @author Fernando-Godoy
 *
 */

@AllArgsConstructor
@EqualsAndHashCode
public class PasswordCheckerResponse {

	private BigDecimal score;

	@Getter
	private LevelScore levelScore;

	public String getDescription() {
		return levelScore.getDescription();
	}

	public Integer getScore() {
		if (score.compareTo(BigDecimal.ZERO) == -1) {
			return BigDecimal.ZERO.intValue();
		} else if (score.compareTo(BigDecimal.valueOf(100)) == 1) {
			return BigDecimal.valueOf(100).intValue();
		} else {
			return score.intValue();
		}
	}
}
