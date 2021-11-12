package by.epam.task03.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.task03.exception.InvalidCharacterException;
import by.epam.task03.logic.CalculatorImpl;
import by.epam.task03.logic.ExpressionValidator;

public class Main {

	public static void main(String[] args) throws InvalidCharacterException {
		String expression = "3-2+(90000-1*2)";
		
		//Pattern pattern = Pattern.compile("\\)");
		//Matcher matcher = pattern.matcher(expression);
		//System.out.println(matcher.find());
		
		CalculatorImpl impl = new CalculatorImpl();
		System.out.println(impl.calculate(expression));
		
		
	}

}
