package application.service.client;

import domain.user.password.EasyCoiffureException;

public class InvalidUserNameException extends EasyCoiffureException {

	public InvalidUserNameException(String username) {
		super("le nom d'utilisateur "+username+"que vous avez entré n'est pas valide");
	}
}
