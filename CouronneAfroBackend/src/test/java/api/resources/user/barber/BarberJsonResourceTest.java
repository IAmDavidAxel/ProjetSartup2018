package api.resources.user.barber;

import application.service.user.barber.BarberService;
import application.service.user.manager.ManagerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberJsonResourceTest {


	private BarberJsonResource barberJsonResource;

	@Mock
	private BarberService barberService;
	@Mock
	private ManagerService managerService;

	private BarberDto barberDto;


	private void setUpDto(){
		barberDto =  new BarberDto();
	}

	@Before
	public void setUp(){
		setUpDto();
		barberJsonResource = new BarberJsonResource(managerService);
	}



	@Test
	public void whenCreatingABarber_thenDelegateToManagerService()throws Exception{
		barberJsonResource.create(barberDto);

		verify(managerService).create(barberDto);
	}
}
