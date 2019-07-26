package infrastructure;

import domain.user.barber.Barber;
import domain.user.barber.BarberRepository;

import java.util.HashMap;
import java.util.List;

public class BarberInMemoryRepository implements BarberRepository {

	private HashMap<String, Barber> barbers = new HashMap<>();


	@Override
	public void save(String name, Barber barber) {
		barbers.put(barber.getName(),barber);
	}

	@Override
	public List<Barber> findAll() {
		return null;
	}

	public int size(){

		return barbers.size();
	}
}
