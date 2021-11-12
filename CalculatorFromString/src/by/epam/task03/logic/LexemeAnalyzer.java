package by.epam.task03.logic;

import java.util.ArrayList;
import java.util.List;

import by.epam.task03.bean.Lexeme;
import by.epam.task03.bean.LexemeType;
import by.epam.task03.exception.InvalidCharacterException;

public class LexemeAnalyzer {
	
	public static List<Lexeme> lexAnalyze(String expText) throws InvalidCharacterException{
		ExpressionValidator validator = new ExpressionValidator();
		validator.validate(expText);
		List<Lexeme> lexemes = new ArrayList<Lexeme>();
		int pos = 0;
		while(pos < expText.length()) {
			char c = expText.charAt(pos);
			switch(c) {
			case '(' :
				lexemes.add(new Lexeme(LexemeType.LEFT_BRECKET, c));
				pos++;
				continue;
			case ')' :
				lexemes.add(new Lexeme(LexemeType.RIGHT_BRECKET, c));
				pos++;
				continue;
			case '+' :
				lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
				pos++;
				continue;
			case '-' :
				lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
				pos++;
				continue;
			case '/' :
				lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
				pos++;
				continue;
			case '*' :
				lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
				pos++;
				continue;
			default:
					if(c <= '9' && c >= '0') {
						StringBuilder sb = new StringBuilder();
						do {
							sb.append(c);
							pos++;
							if(pos >= expText.length()) {
							break;
							}
							c = expText.charAt(pos);
						}while(c <= '9' && c >= '0');
						
						lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
						
					}else {
						pos++;
					}
		
			}
				
		}
		lexemes.add(new Lexeme(LexemeType.EOF, ""));
		return lexemes;
	}

}
