package infrastructure.credential;

import domain.user.Credential;
import domain.user.credential.CredentialRepository;
import infrastructure.ObjectNotFoundException;
import infrastructure.client.PersistenceInternalException;

import java.util.Map;

public class InMemoryCredentialRepository implements CredentialRepository {

	private Map<String, Credential> credentials;
	@Override
	public Credential findByUsername(String username) throws ObjectNotFoundException {
		return credentials.get(username);
	}

	@Override
	public void save(Credential credential, String username) throws PersistenceInternalException {

		credentials.put(username,credential);

	}
}
