package infrastructure.persistence.dao;

import infrastructure.persistence.dao.sqlite.UserDao;
import infrastructure.persistence.dto.ClientDto;
import infrastructure.persistence.exception.DaoEntityNotFoundException;
import infrastructure.persistence.exception.DaoInternalException;

public interface ClientDao  extends UserDao {

	void save(ClientDto clientDto) throws DaoInternalException;

	ClientDto findById(String clientId) throws DaoInternalException, DaoEntityNotFoundException;
}
