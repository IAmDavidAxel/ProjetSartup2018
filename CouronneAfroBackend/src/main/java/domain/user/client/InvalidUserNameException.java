package domain.user.client;

import domain.exception.CouronneAfroException;

public class InvalidUserNameException extends CouronneAfroException {

	public InvalidUserNameException(String username) {
		super("The Provided username: " + username + " is invalid, the username and the email address provided should not be the same");
	}


}
