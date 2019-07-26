package application.service.security;

import application.service.exception.ServiceException;

public class IllegalPasswordFormatServiceException extends ServiceException {

	public IllegalPasswordFormatServiceException() {
		super("The password provided does not respect the password security policy: At least one lower case, one uppercase, one digit and one special character.");
	}
}
