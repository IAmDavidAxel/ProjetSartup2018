package infrastructure.persistence.dao;

import infrastructure.persistence.dao.sqlite.UserDao;
import infrastructure.persistence.dto.ManagerDto;
import infrastructure.persistence.exception.DaoInternalException;

public interface ManagerDao extends UserDao {

	void save(ManagerDto managerDto) throws DaoInternalException;

}
