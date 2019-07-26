package domain.user.password;

import domain.exception.CouronneAfroException;

public class MismatchedPasswordException extends CouronneAfroException {
	public MismatchedPasswordException() {
		super("le mot de passe que vous avez entré ne correspond a celui dans nos base de données");
	}
}
