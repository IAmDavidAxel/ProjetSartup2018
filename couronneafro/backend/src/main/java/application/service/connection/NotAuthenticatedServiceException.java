package application.service.connection;

import application.service.exception.ServiceException;

public class NotAuthenticatedServiceException extends ServiceException {

	public NotAuthenticatedServiceException() {
		super("Probleme rencontre lors de l'authentification verifiez les informations que vous avez entré");
	}
}
