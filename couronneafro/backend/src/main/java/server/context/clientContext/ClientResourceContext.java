package server.context.clientContext;

import api.client.ClientJsonResource;
import api.client.ClientResource;
import application.service.client.ClientFactory;
import application.service.client.ClientService;
import application.service.mail.MailService;
import domain.appointment.AppointmentRepository;
import domain.user.CredentialFactory;
import domain.user.UserProfileFactory;
import domain.user.client.ClientRepository;
import domain.user.identifier.UserIdFactory;
import domain.user.password.JBCryptPasswordFactory;
import domain.user.password.PasswordFactory;
import domain.user.password.PasswordPolicy;
import domain.user.token.TokenFactory;
import utility.ServiceLocator;

public class ClientResourceContext {

	public static ClientResource create (){

		PasswordPolicy passwordPolicy = ServiceLocator.INSTANCE.resolve(PasswordPolicy.class);

		ClientRepository clientRepository = ServiceLocator.INSTANCE.resolve(ClientRepository.class);

		AppointmentRepository appointmentRepository  = ServiceLocator.INSTANCE.resolve(AppointmentRepository.class);

		PasswordFactory JBCryptPasswordFactory = new JBCryptPasswordFactory(passwordPolicy);
		TokenFactory tokenFactory = new TokenFactory();
		CredentialFactory credentialFactory = new CredentialFactory();
		UserProfileFactory userProfileFactory = new UserProfileFactory();
		UserIdFactory userIdFactory = new UserIdFactory();

		ClientFactory clientFactory = new ClientFactory(credentialFactory,userProfileFactory,tokenFactory,JBCryptPasswordFactory);

		MailService mailService = new MailService();

		ClientService clientService = new ClientService(clientFactory,clientRepository, appointmentRepository);

		registerObservers(clientService,mailService);
		startMailService(mailService);

		ServiceLocator.INSTANCE.register(ClientService.class,clientService);



		return new ClientJsonResource(clientService);

	}

	private static void registerObservers(ClientService clientService, MailService mailService) {
		clientService.register(mailService);
		mailService.register(clientService);
	}

	private static void startMailService(MailService mailService) {
		Thread thread = new Thread(mailService);
		thread.start();
	}
}
