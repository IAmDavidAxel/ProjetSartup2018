package application.service.client;

import application.service.exception.ServiceException;

public class IllegalPasswordFormatServiceException extends ServiceException {

	public IllegalPasswordFormatServiceException() {
		super("le mot de passe que vous avez entré ne respecte pas la politique :(");
	}
}
