package br.com.fsg.passwordchecker.enumerator;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.Range;

import lombok.Getter;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public enum LevelScore {

	TOO_SHORT("Too Short") {
		@Override
		Range<BigDecimal> getRange() {
			return Range.between(BigDecimal.valueOf(Long.MIN_VALUE), BigDecimal.ZERO);
		}
	},
	VERY_WEAK("Very Weak") {
		@Override
		Range<BigDecimal> getRange() {
			return Range.between(BigDecimal.ONE, BigDecimal.valueOf(20));
		}
	},
	WEAK("Weak") {
		@Override
		Range<BigDecimal> getRange() {
			return Range.between(BigDecimal.valueOf(21), BigDecimal.valueOf(40));
		}
	},
	GOOD("Good") {
		@Override
		Range<BigDecimal> getRange() {
			return Range.between(BigDecimal.valueOf(41), BigDecimal.valueOf(60));
		}
	},
	STRONG("Strong") {
		@Override
		Range<BigDecimal> getRange() {
			return Range.between(BigDecimal.valueOf(61), BigDecimal.valueOf(80));
		}
	},
	VERY_STRONG("Very Strong") {
		@Override
		Range<BigDecimal> getRange() {
			return Range.between(BigDecimal.valueOf(81), BigDecimal.valueOf(Long.MAX_VALUE));
		}
	};

	abstract Range<BigDecimal> getRange();

	private LevelScore(String description) {
		this.description = description;
	}

	@Getter
	private String description;

	public static LevelScore byScore(BigDecimal rate) {
		return List.of(values()).stream()
				.filter(level -> level.getRange().contains(rate))
				.findFirst()
				.orElse(TOO_SHORT);
	}

}
