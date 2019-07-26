package application.service.security;

import application.service.exception.ServiceException;

@SuppressWarnings("serial")
public class NotAuthenticatedServiceException extends ServiceException {
	public NotAuthenticatedServiceException() {
		super("Not authenticated! Check provided information.");
	}

}
