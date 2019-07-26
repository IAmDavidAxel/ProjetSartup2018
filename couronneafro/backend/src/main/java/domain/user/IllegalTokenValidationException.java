package domain.user;

import domain.user.password.EasyCoiffureException;

public class IllegalTokenValidationException extends EasyCoiffureException {

	public IllegalTokenValidationException() {
		super("les tokens ne sont pas egaux");
	}
}
