package domain.user.credential;

import domain.user.Credential;
import infrastructure.ObjectNotFoundException;
import infrastructure.client.PersistenceInternalException;


public interface CredentialRepository {

	Credential findByUsername(String username) throws ObjectNotFoundException;

	void save(Credential credential, String username) throws PersistenceInternalException;
}
