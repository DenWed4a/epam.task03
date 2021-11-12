package by.epam.task03.exception;

public class InvalidCharacterException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidCharacterException() {
		super();
	}
	public InvalidCharacterException(String message) {
		super(message);
	}
	public InvalidCharacterException(Exception e) {
		super(e);
	}
	public InvalidCharacterException(String message, Exception e) {
		super(message, e);
	}

}
