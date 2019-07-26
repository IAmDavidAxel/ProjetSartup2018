package application.service.client;

import api.appointment.AppointmentDto;
import api.appointment.HairAppointmentDto;
import api.client.ClientDto;
import application.service.connection.PersistenceServiceException;
import application.service.exception.ServiceException;
import application.service.observer.ClientServiceObservable;
import application.service.observer.MailServiceObserver;
import domain.appointment.AppointmentRepository;
import domain.user.client.Client;
import domain.user.client.ClientRepository;
import domain.user.password.IllegalPasswordFormatException;
import infrastructure.client.PersistenceInternalException;
import infrastructure.client.exception.ClientNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientService extends ClientServiceObservable implements MailServiceObserver {

	private ClientFactory clientFactory;
	private ClientRepository clientRepository;
	private AppointmentRepository appointmentRepository;


	public ClientService(ClientFactory clientFactory, ClientRepository clientRepository, AppointmentRepository appointmentRepository) {

		this.clientFactory = clientFactory;
		this.clientRepository = clientRepository;
		this.appointmentRepository = appointmentRepository;
	}

	public void create(ClientDto clientDto)  throws ServiceException {

		Client client = createClient(clientDto);

		clientRepository.save(client);

		notifyClientCreated(client);

	}

	public void makeAppointment(AppointmentDto appointmentDto) throws ServiceException {

		String clientUsername = appointmentDto.getUsername();

		Client  client = findClientByUsername(clientUsername);



		notifyAppointmentMade(client);


	}
	public void makeHairAppointment(HairAppointmentDto hairAppointmentDto) throws ServiceException {

		String username = hairAppointmentDto.getUsername(hairAppointmentDto);

		Client client = findClientByUsername(username);



		notifyAppointmentMade(client);


	}



	private Client createClient(ClientDto clientDto) throws ServiceException{

		try {
			return clientFactory.create(clientDto);
		} catch (IllegalPasswordFormatException |InvalidUserNameException e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
			throw  new EntityCreationServiceException(e);
		}
	}

	@Override
	public void listenMailInvalid(Client client) throws PersistenceInternalException {

		clientRepository.delete(client);

	}

	private Client findClientByUsername(String clientUsername) throws PersistenceServiceException {

		try{
			Client client = clientRepository.findByUsername(clientUsername);
			return client;
		}catch (ClientNotFoundException e){
			throw new PersistenceServiceException();
		}

	}



}
