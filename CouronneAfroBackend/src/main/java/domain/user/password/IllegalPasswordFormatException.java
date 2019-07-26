package domain.user.password;

import domain.exception.CouronneAfroException;

public class IllegalPasswordFormatException extends CouronneAfroException {

	public IllegalPasswordFormatException() {
		super("The provided password does not respect password security policy.");
	}
}
