package domain.user.password;

public class IllegalPasswordFormatException extends EasyCoiffureException {

	public IllegalPasswordFormatException() {
		super("Le mot de passe que vous avez rentré ne respecte pas les politiques :( ");
	}
}
