package application.service.user.client;

import application.service.exception.ServiceException;
import domain.exception.CouronneAfroException;

public class EntityCreationServiceException extends ServiceException {
	public EntityCreationServiceException(CouronneAfroException cause) {
		super(cause);
	}
}
