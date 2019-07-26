package server.context.resourceContext;

import api.resources.dto.user.client.ClientDto;
import api.resources.user.client.ClientJsonResource;
import api.resources.user.client.ClientResource;
import application.service.security.UserSecurityService;
import application.service.user.client.ClientAssembler;
import application.service.user.client.ClientService;
import domain.credential.CredentialFactory;
import domain.token.TokenFactory;
import domain.user.client.Client;
import domain.user.client.ClientFactory;
import domain.user.client.ClientRepository;
import domain.user.client.UserFactory;
import domain.user.id.UserIdFactory;
import domain.user.password.JBCryptPasswordFactory;
import domain.user.password.PasswordFactory;
import domain.user.password.PasswordPolicy;
import domain.user.userProfile.UserProfileFactory;
import utility.servicelocator.ServiceLocator;

public class ClientResourceContext {

	public static ClientResource create(){

		PasswordPolicy passwordPolicy = ServiceLocator.INSTANCE.resolve(PasswordPolicy.class);
		ClientRepository clientRepository = ServiceLocator.INSTANCE.resolve(ClientRepository.class);

		PasswordFactory passwordFactory = new JBCryptPasswordFactory(passwordPolicy);
		TokenFactory tokenFactory = new TokenFactory();
		CredentialFactory credentialFactory = new CredentialFactory();
		UserIdFactory userIdFactory = new UserIdFactory();
		UserProfileFactory userProfileFactory = new UserProfileFactory();
		UserFactory<Client, ClientDto> clientFactory = new ClientFactory(tokenFactory,credentialFactory,userIdFactory,userProfileFactory,passwordFactory);

		ClientAssembler clientAssembler = new ClientAssembler();

		ClientService clientService = new ClientService(clientAssembler,clientRepository,(ClientFactory) clientFactory);

		UserSecurityService userSecurityService = new UserSecurityService(clientRepository, passwordPolicy);


		ServiceLocator.INSTANCE.register(ClientService.class, clientService);

		return new ClientJsonResource(clientService, userSecurityService);
	}
}
