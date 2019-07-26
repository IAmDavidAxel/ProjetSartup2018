package application.service.connection;

import application.service.exception.ServiceException;

public class PersistenceInternalErrorServiceException extends ServiceException {

	public PersistenceInternalErrorServiceException() {
		super("An internal persistence error occurred.");
	}
}
