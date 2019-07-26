package application.service.security;

import application.service.exception.ServiceException;

public class InvalidTokenServiceException extends ServiceException {

	public InvalidTokenServiceException() {
		super("");
	}
}
