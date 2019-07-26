package infrastructure.persistence.repository;

import application.service.security.ObjectNotFoundException;
import domain.credential.Credential;
import domain.credential.CredentialRepository;
import infrastructure.persistence.assembler.CredentialAssembler;
import infrastructure.persistence.dao.sqlite.UserDao;
import infrastructure.persistence.dto.CredentialDto;
import infrastructure.persistence.exception.DaoEntityNotFoundException;
import infrastructure.persistence.exception.DaoInternalException;
import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteCredentialRepository  implements CredentialRepository {

	private final CredentialAssembler credentialAssembler;
	private final UserDao userDao;

	public SqliteCredentialRepository(CredentialAssembler credentialAssembler, UserDao userDao) {

		this.credentialAssembler = credentialAssembler;
		this.userDao = userDao;
	}

	@Override
	public Credential findByUsername(String username) throws PersistenceInternalException, ObjectNotFoundException {
		CredentialDto credentialDto;

		try{
			credentialDto = userDao.findCredentialByUsername(username);
		}catch (DaoInternalException e){
			Logger.getGlobal().log(Level.WARNING, e.getMessage());
			throw  new PersistenceInternalException();
		}catch (DaoEntityNotFoundException e){
			Logger.getGlobal().log(Level.WARNING, e.getMessage());
			throw  new ObjectNotFoundException();
		}

		return credentialAssembler.assemble(credentialDto);
	}

	@Override
	public void saveCredential(Credential credential, String username) throws PersistenceInternalException {

		CredentialDto credentialDto = credentialAssembler.assemble(credential);

		try{
			userDao.saveCredential(credentialDto,username);
		}catch (DaoInternalException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
			throw new PersistenceInternalException();
		}


	}
}
