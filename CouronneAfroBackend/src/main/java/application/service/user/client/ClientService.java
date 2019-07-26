package application.service.user.client;

import api.resources.dto.user.client.ClientDto;
import application.service.exception.ServiceException;
import application.service.security.PersistenceInternalErrorServiceException;
import domain.user.client.Client;
import domain.user.client.ClientFactory;
import domain.user.client.ClientRepository;
import domain.user.client.InvalidUserNameException;
import domain.user.password.IllegalPasswordFormatException;
import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientService {
	private  ClientAssembler clientAssembler;
	private  ClientRepository clientRepository;
	private ClientFactory clientFactory;


	public ClientService(ClientAssembler clientAssembler, ClientRepository clientRepository, ClientFactory clientFactory) {

		this.clientAssembler = clientAssembler;
		this.clientRepository = clientRepository;
		this.clientFactory = clientFactory;
	}

	public void create(ClientDto clientDto) throws ServiceException {

		Client client = createClient(clientDto);
		saveClient(client);

	}

	private void saveClient(Client client) throws ServiceException {
		try {
			clientRepository.save(client);
		} catch (PersistenceInternalException e) {
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
			throw  new PersistenceInternalErrorServiceException();
		}
	}

	private Client createClient(ClientDto clientDto) throws ServiceException{
		try {
			return clientFactory.create(clientDto);
		} catch (InvalidUserNameException | IllegalPasswordFormatException exception){
			throw  new EntityCreationServiceException(exception);
		}

	}
}
