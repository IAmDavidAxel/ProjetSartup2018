package server.context.resourceContext;

import api.resources.user.barber.BarberDto;
import api.resources.user.barber.BarberJsonResource;
import api.resources.user.barber.BarberResource;
import domain.user.barber.BarberFactory;
import application.service.user.manager.ManagerService;
import domain.credential.CredentialFactory;
import domain.token.TokenFactory;
import domain.user.barber.Barber;
import domain.user.barber.BarberRepository;
import domain.user.client.ClientRepository;
import domain.user.client.UserFactory;
import domain.user.id.UserIdFactory;
import domain.user.password.JBCryptPasswordFactory;
import domain.user.password.PasswordFactory;
import domain.user.password.PasswordPolicy;
import domain.user.userProfile.UserProfileFactory;
import utility.servicelocator.ServiceLocator;

public class BarberResourceContext {

	public static BarberResource create(){

		PasswordPolicy passwordPolicy = ServiceLocator.INSTANCE.resolve(PasswordPolicy.class);

		BarberRepository barberRepository = ServiceLocator.INSTANCE.resolve(BarberRepository.class);

		ClientRepository clientRepository = ServiceLocator.INSTANCE.resolve(ClientRepository.class);

		PasswordFactory passwordFactory = new JBCryptPasswordFactory(passwordPolicy);
		TokenFactory tokenFactory = new TokenFactory();
		CredentialFactory credentialFactory = new CredentialFactory();
		UserIdFactory userIdFactory = new UserIdFactory();
		UserProfileFactory userProfileFactory = new UserProfileFactory();

		UserFactory<Barber, BarberDto> barberFactory = new BarberFactory(passwordFactory,tokenFactory,credentialFactory,userIdFactory,userProfileFactory);

		ManagerService managerService = new ManagerService((BarberFactory) barberFactory,barberRepository);

		return new BarberJsonResource(managerService);

	}
}
