package application.service.observer;

import domain.user.client.Client;

public interface ClientServiceObserver {

	void listenClientCreated(Client client);

	void listenAppointmentMadeByClient(Client client);

	void listenHairAppointmentMadeByClient(Client client);
}
