package domain.user.client;

import application.service.security.ObjectNotFoundException;
import infrastructure.persistence.exception.PersistenceInternalException;

public interface ClientRepository {

	boolean existByUsername(String username) throws PersistenceInternalException;

	boolean existById(String id) throws PersistenceInternalException;

	void save(Client client) throws PersistenceInternalException;

	Client findById(String clientId) throws PersistenceInternalException, ObjectNotFoundException;

	void delete(Client client) throws PersistenceInternalException;
}
