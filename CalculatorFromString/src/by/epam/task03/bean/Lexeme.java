package by.epam.task03.bean;

public class Lexeme {
	
	private LexemeType type;
	private String value;
	
	
	public Lexeme(LexemeType type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public Lexeme(LexemeType type, Character value) {
		this.type = type;
		this.value = value.toString();
	}
	
	

	public String getValue() {
		return value;
	}

	public LexemeType getType() {
		return type;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lexeme other = (Lexeme) obj;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lexem [type=" + type + ", value=" + value + "]";
	}
	
}
