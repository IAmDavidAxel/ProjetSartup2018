package application.service.user.barber;

import api.resources.user.barber.BarberDto;
import domain.user.barber.BarberFactory;
import domain.user.barber.BarberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberServiceTest {

	private BarberService barberService;

	@Mock
	private BarberFactory barberFactory;
	@Mock
	private BarberRepository barberRepository;
	private BarberDto barberDto;

	private void setUpBarberDto(){
		barberDto = new BarberDto();
	}

	@Before
	public void setUp(){
		setUpBarberDto();
		barberService = new BarberService(barberFactory,barberRepository);
	}

	@Test
	public void whenCeating()throws Exception{

		assertEquals(1,1);
	}



}
