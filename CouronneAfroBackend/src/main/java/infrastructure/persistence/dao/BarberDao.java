package infrastructure.persistence.dao;

import infrastructure.persistence.dto.BarberDto;
import infrastructure.persistence.exception.DaoInternalException;

public interface BarberDao {
	void save(BarberDto barberDto) throws DaoInternalException;
}
