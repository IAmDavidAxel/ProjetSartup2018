package infrastructure.persistence.dao.sqlite;

import infrastructure.persistence.dto.CredentialDto;
import infrastructure.persistence.dto.UserProfileDto;
import infrastructure.persistence.exception.DaoEntityNotFoundException;
import infrastructure.persistence.exception.DaoInternalException;

public interface UserDao {

	boolean existByUsername(String username) throws DaoInternalException;

	boolean existById(String id) throws DaoInternalException;

	void delete(UserProfileDto userProfileDto) throws DaoInternalException;

	void save(UserProfileDto userProfileDto, CredentialDto credentialDto) throws DaoInternalException;

	CredentialDto findCredentialByUsername(String username) throws DaoInternalException, DaoEntityNotFoundException;

	void saveCredential(CredentialDto credentialDto, String username) throws DaoInternalException;
}
