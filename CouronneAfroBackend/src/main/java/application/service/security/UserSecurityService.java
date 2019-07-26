package application.service.security;

import api.dto.ClientProfileSecurityDto;
import application.service.exception.ServiceException;
import domain.user.client.Client;
import domain.user.client.ClientRepository;
import domain.user.password.MismatchedPasswordException;
import domain.user.password.PasswordPolicy;
import infrastructure.persistence.exception.PersistenceInternalException;

public class UserSecurityService {

	private ClientRepository clientRepository;
	private PasswordPolicy passwordPolicy;

	public UserSecurityService(ClientRepository clientRepository, PasswordPolicy passwordPolicy) {
		this.clientRepository = clientRepository;
		this.passwordPolicy = passwordPolicy;
	}


	public void updatePassword(String clientId, ClientProfileSecurityDto clientProfileSecurityDto) throws ServiceException {
		String oldPassword = clientProfileSecurityDto.getOldPassword();
		String newPassword = clientProfileSecurityDto.getNewPassword();

		Client client = getClientFromRepository(clientId);
		verifyOldPassword(oldPassword, client);
		changeClientPassword(newPassword, client);
		saveUpdatedClient(client);
	}

	private void saveUpdatedClient(Client client) throws PersistenceInternalErrorServiceException {
		try {
			clientRepository.save(client);
		} catch (PersistenceInternalException exception) {
			throw new PersistenceInternalErrorServiceException();
		}
	}

	private void changeClientPassword(String newPassword, Client client) throws IllegalPasswordFormatServiceException {
		if (passwordPolicy.isValid(newPassword)) {
			client.changePassword(newPassword);
		} else {
			throw new IllegalPasswordFormatServiceException();
		}
	}

	private void verifyOldPassword(String oldPassword, Client client) throws MismatchedPasswordServiceException {
		try {
			client.verifyPassword(oldPassword);
		} catch (MismatchedPasswordException exception) {
			throw new MismatchedPasswordServiceException();
		}
	}

	private Client getClientFromRepository(String clientId) throws ServiceException {
		Client client;
		try {
			client = clientRepository.findById(clientId);
		} catch (ObjectNotFoundException exception) {
			throw new ClientNotFoundServiceException(clientId);
		} catch (PersistenceInternalException exception) {
			throw new PersistenceInternalErrorServiceException();
		}
		return client;
	}


}
