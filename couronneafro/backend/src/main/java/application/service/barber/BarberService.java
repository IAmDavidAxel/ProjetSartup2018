package application.service.barber;

import api.barber.BarberDto;
import domain.user.barber.Barber;
import domain.user.barber.BarberRepository;

import java.util.List;

public class BarberService {

	private BarberRepository barberRepository;
	private BarberAssembler barberAssembler;

	public BarberService(BarberRepository barberRepository, BarberAssembler barberAssembler) {
		this.barberRepository = barberRepository;
		this.barberAssembler = barberAssembler;
	}

	public void create(BarberDto barberDto) {

		Barber barber = barberAssembler.assemble(barberDto);
		barberRepository.save(barber.getName(),barber);

	}

	public List<BarberDto> findAllBarbers() {

		List<Barber> barbers = barberRepository.findAll();


		List<BarberDto> barberDtos = barberAssembler.assemble(barbers);

		return barberDtos;
	}
}
