package domain.user.barber;

import infrastructure.persistence.exception.PersistenceInternalException;

public interface BarberRepository {
	void save(Barber barber) throws PersistenceInternalException;
}
