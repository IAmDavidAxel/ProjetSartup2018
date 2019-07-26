package infrastructure.persistence.repository.sqlite;

import application.service.security.ObjectNotFoundException;
import domain.user.client.Client;
import domain.user.client.ClientRepository;
import infrastructure.persistence.assembler.ClientAssembler;
import infrastructure.persistence.dao.ClientDao;
import infrastructure.persistence.dto.ClientDto;
import infrastructure.persistence.exception.DaoEntityNotFoundException;
import infrastructure.persistence.exception.DaoInternalException;
import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteClientRepository implements ClientRepository {

	private ClientAssembler clientAssembler;
	private ClientDao clientDao;

	public SqliteClientRepository(ClientAssembler clientAssembler, ClientDao clientDao) {
		this.clientAssembler = clientAssembler;
		this.clientDao = clientDao;
	}

	@Override
	public boolean existByUsername(String username) throws PersistenceInternalException {

		try {
			return clientDao.existByUsername(username);
		} catch (DaoInternalException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new PersistenceInternalException();
		}
	}

	@Override
	public boolean existById(String id) throws PersistenceInternalException {
		try {
			return clientDao.existById(id);
		} catch (DaoInternalException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new PersistenceInternalException();
		}
	}

	@Override
	public void save(Client client) throws PersistenceInternalException {

		ClientDto clientDto = clientAssembler.assemble(client);
		try {
			clientDao.save(clientDto);
		} catch (DaoInternalException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new PersistenceInternalException();
		}

	}

	@Override
	public Client findById(String clientId) throws PersistenceInternalException, ObjectNotFoundException {
		ClientDto clientDto;
		try {
			clientDto = clientDao.findById(clientId);
		} catch (DaoInternalException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new PersistenceInternalException();
		} catch (DaoEntityNotFoundException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new ObjectNotFoundException();
		}

		return clientAssembler.assemble(clientDto);
	}

	@Override
	public void delete(Client client) throws PersistenceInternalException {

		ClientDto clientDto = clientAssembler.assemble(client);
		try {
			clientDao.delete(clientDto.getUserProfileDto());
		} catch (DaoInternalException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new PersistenceInternalException();
		}
	}

	}

