package by.epam.task03.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.task03.exception.InvalidCharacterException;

public class ExpressionValidator {

	public boolean validate(String expression) throws InvalidCharacterException {
		boolean result = true;
		Pattern pattern = Pattern.compile("[^\\(\\)\\d\\+-/\\*\\s]");
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			result = false;
			throw new InvalidCharacterException("invalid character in expression");
		}
		return result;
	}

}
