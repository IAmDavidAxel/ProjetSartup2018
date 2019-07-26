package application.service.connection;

import application.service.exception.ServiceException;

public class PersistenceServiceException extends ServiceException {

	public PersistenceServiceException() {
		super("Probleme de sauvegarde de votre profil");
	}
}
