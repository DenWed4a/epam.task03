package by.epam.task03.logic;

import by.epam.task03.bean.LexemeBuffer;
import by.epam.task03.exception.InvalidCharacterException;

public class CalculatorImpl implements Calculator{

	@Override
	public int calculate(String expression) throws InvalidCharacterException {
		LexemeBuffer buffer = new LexemeBuffer(LexemeAnalyzer.lexAnalyze(expression));
		int result = SyntacticalAnalyzer.expr(buffer);
		return result;
	}

}
