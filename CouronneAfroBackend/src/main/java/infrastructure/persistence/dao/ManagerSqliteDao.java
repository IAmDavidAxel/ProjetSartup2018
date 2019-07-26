package infrastructure.persistence.dao;

import infrastructure.persistence.dao.sqlite.UserSqliteDao;
import infrastructure.persistence.dto.CredentialDto;
import infrastructure.persistence.dto.ManagerDto;
import infrastructure.persistence.dto.UserProfileDto;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;
import infrastructure.persistence.exception.DaoInternalException;

public class ManagerSqliteDao extends UserSqliteDao implements ManagerDao {

	public ManagerSqliteDao(SqliteConnection connection) {
		super(connection);
	}

	@Override
	public void save(ManagerDto managerDto) throws DaoInternalException {
		super.save(managerDto.getUserProfileDto(),managerDto.getCredentialDto());
	}
}
