package server.context.barberContext;

import api.barber.BarberJsonResource;
import application.service.barber.BarberAssembler;
import application.service.barber.BarberService;
import domain.user.barber.BarberRepository;
import utility.ServiceLocator;


public class BarberResourceContext {

	public static BarberJsonResource create (){

		BarberAssembler barberAssembler = new BarberAssembler();

		BarberRepository barberRepository = ServiceLocator.INSTANCE.resolve(BarberRepository.class);

		BarberService barberService = new BarberService(barberRepository,barberAssembler);
		return new BarberJsonResource(barberService);
	}

}
