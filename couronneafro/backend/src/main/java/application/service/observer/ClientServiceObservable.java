package application.service.observer;

import domain.user.client.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceObservable {

	private List<ClientServiceObserver> observers = new ArrayList<>();


	public void register(ClientServiceObserver clientServiceObserver) {
		observers.add(clientServiceObserver);
	}

	public void notifyClientCreated(Client client) {

		for(ClientServiceObserver observer : observers){
			observer.listenClientCreated(client);
		}

	}

	public void notifyAppointmentMade(Client client){

		for(ClientServiceObserver observer : observers){

			observer.listenAppointmentMadeByClient(client);

		}
	}

	public void notifyHairAppointmentMade(Client client){

		for ( ClientServiceObserver observer : observers){

			observer.listenHairAppointmentMadeByClient(client);
		}
	}
}
