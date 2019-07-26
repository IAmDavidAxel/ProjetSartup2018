package domain.user.client;

import infrastructure.client.PersistenceInternalException;
import infrastructure.client.exception.ClientNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ClientRepositoryInMemory implements ClientRepository {

	private Map<String,Client> clientMap = new HashMap<>();


	@Override
	public void save(Client client) {

		clientMap.put(client.getUserProfile().getUsername(),client);

	}

	@Override
	public void delete(Client client) throws PersistenceInternalException {
		clientMap.remove(client);
	}

	@Override
	public Client findByUsername(String clientUsername) throws ClientNotFoundException {


		if(clientMap.containsKey(clientUsername)){

			Client client = clientMap.get(clientUsername);

			return client;
		}
		else{

			throw new ClientNotFoundException();
		}

	}
}
