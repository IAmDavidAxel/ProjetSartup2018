package application.service.connection;

import application.service.exception.ServiceException;

public class InvalidTokenServiceException extends ServiceException {
	public InvalidTokenServiceException(){
		super("Invalid provided token.");
	}
}
