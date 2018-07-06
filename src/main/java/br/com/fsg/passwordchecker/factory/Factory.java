package br.com.fsg.passwordchecker.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fsg.passwordchecker.additions.LowerLettersChecker;
import br.com.fsg.passwordchecker.additions.MiddleNumbersOrSymbolsChecker;
import br.com.fsg.passwordchecker.additions.NumberChecker;
import br.com.fsg.passwordchecker.additions.NumberOfCharacterChecker;
import br.com.fsg.passwordchecker.additions.RequirementsChecker;
import br.com.fsg.passwordchecker.additions.SymbolChecker;
import br.com.fsg.passwordchecker.additions.UpperLettersChecker;
import br.com.fsg.passwordchecker.deduction.ConsecutiveLowerLettersChecker;
import br.com.fsg.passwordchecker.deduction.ConsecutiveNumbersChecker;
import br.com.fsg.passwordchecker.deduction.ConsecutiveUpperLettersChecker;
import br.com.fsg.passwordchecker.deduction.LettersOnlyChecker;
import br.com.fsg.passwordchecker.deduction.NumbersOnlyChecker;
import br.com.fsg.passwordchecker.deduction.RepeatCharactersChecker;
import br.com.fsg.passwordchecker.deduction.SequentialLettersChecker;
import br.com.fsg.passwordchecker.deduction.SequentialNumbersChecker;
import br.com.fsg.passwordchecker.deduction.SequentialSymbolsChecker;
import br.com.fsg.passwordchecker.util.Meter;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@Service
public class Factory {

	private static final List<Meter> LIST_DEDUTION_METRICS = new ArrayList<>();

	private static final List<Meter> LIST_ADDITION_METRICS = new ArrayList<>();

	public List<Meter> additionsFactory() {
		return LIST_ADDITION_METRICS;
	}

	public List<Meter> deductionsFactory() {
		return LIST_DEDUTION_METRICS;
	}

	static {
		LIST_DEDUTION_METRICS.addAll(List.of(
				new ConsecutiveLowerLettersChecker(),
				new ConsecutiveNumbersChecker(),
				new ConsecutiveUpperLettersChecker(),
				new LettersOnlyChecker(),
				new NumbersOnlyChecker(),
				new RepeatCharactersChecker(),
				new SequentialLettersChecker(),
				new SequentialNumbersChecker(),
				new SequentialSymbolsChecker()));

		LIST_ADDITION_METRICS.addAll(List.of(new LowerLettersChecker(),
				new MiddleNumbersOrSymbolsChecker(),
				new NumberChecker(),
				new NumberOfCharacterChecker(),
				new RequirementsChecker(),
				new SymbolChecker(),
				new UpperLettersChecker()));
	}

}
