package application.service.observer;

import application.service.connection.PersistenceServiceException;
import domain.user.client.Client;
import infrastructure.client.PersistenceInternalException;

import java.util.ArrayList;
import java.util.List;

public class MailServiceObservable {

	private List<MailServiceObserver> observers = new ArrayList<>();

	public void register(MailServiceObserver mailServiceObserver){
		observers.add(mailServiceObserver);
	}

	public void unregister(MailServiceObserver mailServiceObserver){
		observers.remove(mailServiceObserver);
	}


	public void notifyInvalidMail(Client client) throws PersistenceInternalException, PersistenceServiceException {

		for (MailServiceObserver mailServiceObserver : observers){
			mailServiceObserver.listenMailInvalid(client);
		}

	}
}
