package api.barber;

import application.service.barber.BarberService;

import java.util.List;


public class BarberJsonResource implements BarberResource {
	private BarberService barberService;

	public BarberJsonResource(BarberService barberService) {

		this.barberService = barberService;
	}


	@Override
	public void create(BarberDto barberDto) {

		barberService.create(barberDto);
	}

	@Override
	public List<BarberDto> listAllBarbers() {

		barberService.findAllBarbers();
		return null;
	}
}
