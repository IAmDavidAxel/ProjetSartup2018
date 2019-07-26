package application.service.user.manager;

import api.resources.user.barber.BarberDto;
import application.service.exception.ServiceException;
import application.service.security.PersistenceInternalErrorServiceException;
import application.service.user.client.EntityCreationServiceException;
import domain.user.barber.Barber;
import domain.user.barber.BarberFactory;
import domain.user.barber.BarberRepository;
import domain.user.password.IllegalPasswordFormatException;
import infrastructure.persistence.exception.PersistenceInternalException;

public class ManagerService {

	private BarberFactory barberFactory;
	private  BarberRepository barberRepository;

	public ManagerService(BarberFactory barberFactory, BarberRepository barberRepository) {

		this.barberFactory = barberFactory;
		this.barberRepository = barberRepository;
	}

	public void create(BarberDto barberDto)  throws ServiceException {

		Barber barber = createBarberFromFactory(barberDto);

		saveBarber(barber);
	}

	private void saveBarber(Barber barber) throws ServiceException {

		try {
			barberRepository.save(barber);
		}catch (PersistenceInternalException e){
			throw  new PersistenceInternalErrorServiceException();
		}
	}

	private Barber createBarberFromFactory(BarberDto barberDto) throws ServiceException {

		try {
			return barberFactory.create(barberDto);

		}catch (IllegalPasswordFormatException e){
			throw  new EntityCreationServiceException(e);
		}

	}
}
