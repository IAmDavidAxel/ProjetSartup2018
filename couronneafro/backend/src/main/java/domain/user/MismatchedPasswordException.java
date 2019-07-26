package domain.user;

import domain.user.password.EasyCoiffureException;

public class MismatchedPasswordException extends EasyCoiffureException {
	public MismatchedPasswordException(String message) {
		super(message);
	}
}
