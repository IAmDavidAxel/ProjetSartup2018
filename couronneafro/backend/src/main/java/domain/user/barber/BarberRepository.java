package domain.user.barber;

import java.util.List;

public interface BarberRepository {
	void save(String name, Barber barber);

	List<Barber> findAll();
}
