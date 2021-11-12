package by.epam.task03.logic;

import by.epam.task03.bean.Lexeme;
import by.epam.task03.bean.LexemeBuffer;
import by.epam.task03.bean.LexemeType;
import by.epam.task03.exception.InvalidCharacterException;

public class SyntacticalAnalyzer {

	/*------------------------------------------------------------------
	 * PARSER RULES
	 *------------------------------------------------------------------*/

//    expr : plusminus* EOF ;
//
//    plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;
//
//    multdiv : factor ( ( '*' | '/' ) factor )* ;
//
//    factor : NUMBER | '(' expr ')' ;

	public static int factor(LexemeBuffer lexemes) throws InvalidCharacterException {
		Lexeme lexeme = lexemes.next();
		switch (lexeme.getType()) {
		case NUMBER:
			return Integer.parseInt(lexeme.getValue());

		case LEFT_BRECKET:
			int value = expr(lexemes);
			lexeme = lexemes.next();
			if (lexeme.getType() != LexemeType.RIGHT_BRECKET) {
				throw new RuntimeException(
						"Unexpected token: " + lexeme.getValue() + " at position: " + lexemes.getPos());
			}
			return value;
		default:
			throw new InvalidCharacterException("Unexpected token: " + lexeme.getValue() + " at position: " + lexemes.getPos());
		}

	}

	public static int multidiv(LexemeBuffer lexemes) throws InvalidCharacterException {
		int value = factor(lexemes);

		while (true) {
			Lexeme lexem = lexemes.next();
			switch (lexem.getType()) {
			case OP_MUL:
				value *= factor(lexemes);
				break;
			case OP_DIV:
				value /= factor(lexemes);
				break;
			default:
				lexemes.back();
				return value;

			}
		}

	}

	public static int plusminus(LexemeBuffer lexemes) throws InvalidCharacterException {
		int value = multidiv(lexemes);

		while (true) {
			Lexeme lexem = lexemes.next();
			switch (lexem.getType()) {
			case OP_PLUS:
				value += multidiv(lexemes);
				break;
			case OP_MINUS:
				value -= multidiv(lexemes);
				break;
			default:
				lexemes.back();
				return value;

			}
		}
	}

	public static int expr(LexemeBuffer lexemes) throws InvalidCharacterException {
		Lexeme lexem = lexemes.next();
		if (lexem.getType() == LexemeType.EOF) {
			return 0;

		} else {
			lexemes.back();
			return plusminus(lexemes);
		}

	}

}
