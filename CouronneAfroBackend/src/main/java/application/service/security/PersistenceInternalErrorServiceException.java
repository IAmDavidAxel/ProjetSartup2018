package application.service.security;

import application.service.exception.ServiceException;

@SuppressWarnings("serial")
public class PersistenceInternalErrorServiceException extends ServiceException {

	public PersistenceInternalErrorServiceException() {
		super("An internal persistence error occurred.");
	}
}
