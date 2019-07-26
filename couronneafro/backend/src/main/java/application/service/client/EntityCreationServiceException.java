package application.service.client;

import application.service.exception.ServiceException;
import domain.user.password.EasyCoiffureException;

public class EntityCreationServiceException extends ServiceException {
	public EntityCreationServiceException(EasyCoiffureException cause) {

		super(cause);
	}
}
