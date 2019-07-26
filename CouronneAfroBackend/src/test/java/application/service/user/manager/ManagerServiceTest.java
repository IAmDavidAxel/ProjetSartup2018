package application.service.user.manager;

import api.resources.user.barber.BarberDto;
import domain.user.barber.BarberFactory;
import domain.user.barber.Barber;
import domain.user.barber.BarberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

	private ManagerService managerService;
	private BarberDto barberDto;

	@Mock
	private BarberRepository barberRepository;
	@Mock
	private BarberFactory barberFactory;
	private Barber barber;

	@Before
	public void setUp(){

		managerService = new ManagerService(barberFactory,barberRepository);
	}

	@Test
	public void whenCreatingANewBarber_thenDelegateToFactory()throws Exception{
		managerService.create(barberDto);

		verify(barberFactory).create(barberDto);

	}

	@Test
	public void whenSaving_thenDelegateToTheRepo()throws Exception{

		managerService.create(barberDto);

		verify(barberRepository).save(barber);
	}

}
