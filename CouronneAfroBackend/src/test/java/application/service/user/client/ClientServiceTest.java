package application.service.user.client;

import api.resources.dto.user.client.ClientDto;
import domain.user.client.Client;
import domain.user.client.ClientFactory;
import domain.user.client.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

	private ClientService clientService;

	@Mock
	private ClientAssembler clientAssembler;
	@Mock
	private ClientRepository clientRepository;
	@Mock
	private ClientFactory clientFactory;
	private ClientDto clientDto;
	private Client client;

	@Before
	public void setUp(){
		clientService = new ClientService(clientAssembler,clientRepository,clientFactory);

		clientDto = new ClientDto();
	}

	@Test
	public void whenCreatingANewUser_thenAssemblerChangeToDomainObject()throws Exception{

		clientService.create(clientDto);

		verify(clientFactory).create(clientDto);
	}

	@Test
	public void whenSavingTheUser_thenDelegateToTheRepo()throws Exception{

		willReturn(client).given(clientFactory).create(clientDto);

		clientService.create(clientDto);

		verify(clientRepository).save(client);

	}

}