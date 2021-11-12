package by.epam.task03.logic;

import by.epam.task03.exception.InvalidCharacterException;

public interface Calculator {
	
	public int calculate(String expression) throws InvalidCharacterException;

}
