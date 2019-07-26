package application.service.observer;

import application.service.connection.PersistenceServiceException;
import domain.user.client.Client;
import infrastructure.client.PersistenceInternalException;

public interface MailServiceObserver {

	void listenMailInvalid(Client client) throws PersistenceServiceException, PersistenceInternalException;
}
