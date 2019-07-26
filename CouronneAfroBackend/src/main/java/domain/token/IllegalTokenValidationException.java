package domain.token;

import domain.exception.CouronneAfroException;

public class IllegalTokenValidationException extends CouronneAfroException {
	public IllegalTokenValidationException() {
		super("the token provided is incorrect");
	}
}
