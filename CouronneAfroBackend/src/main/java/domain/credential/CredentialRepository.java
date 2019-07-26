package domain.credential;

import application.service.security.ObjectNotFoundException;
import infrastructure.persistence.exception.PersistenceInternalException;

public interface CredentialRepository {
	Credential findByUsername(String username) throws PersistenceInternalException, ObjectNotFoundException;

	void saveCredential(Credential credential, String username) throws PersistenceInternalException;
}
