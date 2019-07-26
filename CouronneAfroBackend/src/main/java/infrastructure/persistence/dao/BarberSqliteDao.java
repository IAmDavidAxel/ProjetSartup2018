package infrastructure.persistence.dao;

import infrastructure.persistence.dao.sqlite.UserSqliteDao;
import infrastructure.persistence.dao.sqlite.builder.SqliteBuilder;
import infrastructure.persistence.dto.BarberDto;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;
import infrastructure.persistence.exception.DaoInternalException;

public class BarberSqliteDao extends UserSqliteDao implements BarberDao {
	public BarberSqliteDao(SqliteConnection connection) {
		super(connection);
	}

	@Override
	public void save(BarberDto barberDto) throws DaoInternalException {

		super.save(barberDto.getUserProfile(),barberDto.getCredential());

		SqliteBuilder builder = new SqliteBuilder(connection);

		builder.ReplaceInto("barber")
				.Columns("barber_id","first_name","last_name","phone_number")
				.Values(barberDto.getUserProfile().getUserId(),
						barberDto.getUserProfile().getFirstName(),
						barberDto.getUserProfile().getLastName(),
						barberDto.getPhoneNumber())
				.Execute();


	}
}
