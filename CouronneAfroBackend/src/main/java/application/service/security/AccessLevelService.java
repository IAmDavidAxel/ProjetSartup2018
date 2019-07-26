package application.service.security;

import application.service.exception.ServiceException;
import domain.credential.Credential;
import domain.credential.CredentialRepository;
import domain.user.AccessLevel;
import infrastructure.persistence.exception.PersistenceInternalException;

public class AccessLevelService {

	private CredentialRepository credentialRepository;

	public AccessLevelService(CredentialRepository credentialRepository) {
		this.credentialRepository = credentialRepository;
	}

	public boolean verifyAccesLevel(String username, AccessLevel resourceAccessLevel) throws ServiceException{
		try {
			Credential credential = credentialRepository.findByUsername(username);
			return credential.haveAccessTo(resourceAccessLevel);
		}catch (ObjectNotFoundException e){
			throw  new ForbiddenResourceAccessServiceException("Access forbidden");
		} catch (PersistenceInternalException e){
			throw  new PersistenceInternalErrorServiceException();
		}
	}
}
