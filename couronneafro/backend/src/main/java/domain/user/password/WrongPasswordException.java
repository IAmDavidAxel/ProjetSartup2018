package domain.user.password;

public class WrongPasswordException extends EasyCoiffureException {

	public WrongPasswordException() {
		super("le mot de passe que vous avez entré est erroné");
	}
}
