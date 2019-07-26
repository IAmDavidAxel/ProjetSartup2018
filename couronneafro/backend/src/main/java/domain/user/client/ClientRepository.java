package domain.user.client;

import infrastructure.client.PersistenceInternalException;
import infrastructure.client.exception.ClientNotFoundException;

public interface ClientRepository {
	void save(Client client);

	void delete(Client client) throws PersistenceInternalException;

	Client findByUsername(String clientUsername) throws  ClientNotFoundException;
}
