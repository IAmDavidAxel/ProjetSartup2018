package api.resources.user.client;

import application.service.security.UserSecurityService;
import application.service.user.client.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import api.resources.dto.user.client.ClientDto;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientJsonResourceTest {

	private ClientJsonResource clientJsonResource;
	@Mock
	private ClientService clientService;
	private ClientDto clientDto;
	@Mock
	private UserSecurityService userSecurityService;

	@Before
	public void setUp(){
		clientJsonResource = new ClientJsonResource(clientService, userSecurityService);
		clientDto = new ClientDto();
	}

	@Test
	public  void whenCreatingANewClient_thenDelegateToTheService()throws Exception{

		clientJsonResource.create(clientDto);

		verify(clientService).create(clientDto);
	}
}
