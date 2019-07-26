package application.service.security;

import application.service.exception.ServiceException;

public class ClientNotFoundServiceException extends ServiceException {
	public ClientNotFoundServiceException(String clientId) {
		super("The client identified by '" + clientId + "' does not exist in the system, please provide an existent ID.");
	}
}
