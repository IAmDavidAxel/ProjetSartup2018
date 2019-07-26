package application.service.user.barber;

import api.resources.user.barber.BarberDto;
import domain.user.barber.BarberFactory;
import domain.user.barber.BarberRepository;

public class BarberService {

	private BarberFactory barberFactory;
	private  BarberRepository barberRepository;

	public BarberService(BarberFactory barberFactory, BarberRepository barberRepository) {

		this.barberFactory = barberFactory;
		this.barberRepository = barberRepository;
	}

	public void create(BarberDto barberDto) {

	}
}
