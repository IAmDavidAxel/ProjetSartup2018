package server.context;

import api.barber.BarberJsonResource;
import api.client.ClientResource;
import api.connection.ConnectionResource;
import application.service.connection.AuthenticationService;
import application.service.connection.SecurityAssembler;
import domain.appointment.AppointmentInMemoryRepo;
import domain.appointment.AppointmentRepository;
import domain.user.barber.BarberRepository;
import domain.user.client.ClientRepository;
import domain.user.client.ClientRepositoryInMemory;
import domain.user.credential.CredentialRepository;
import domain.user.password.PasswordPolicy;
import domain.user.password.PasswordPolicyFactory;
import domain.user.token.Base64TokenEncoder;
import domain.user.token.TokenEncoder;
import infrastructure.BarberInMemoryRepository;
import infrastructure.credential.InMemoryCredentialRepository;
import server.context.barberContext.BarberResourceContext;
import server.context.clientContext.ClientResourceContext;
import server.context.connectionResourceContext.ConnectionResourceContext;
import utility.ApplicationConfiguration;
import utility.ServiceLocator;

public class DevelopmentContext extends Context {


	@Override
	public void registerService() {

		BarberInMemoryRepository barberRepository = new BarberInMemoryRepository();

		ServiceLocator.INSTANCE.register(BarberRepository.class,barberRepository);

		CredentialRepository credentialRepository = new InMemoryCredentialRepository();

		ClientRepository clientRepository = new ClientRepositoryInMemory();

		AppointmentRepository appointmentRepository = new AppointmentInMemoryRepo();


		PasswordPolicy passwordPolicy = PasswordPolicyFactory.create(ApplicationConfiguration.passwordPolicyMode);

		TokenEncoder tokenEncoder = new Base64TokenEncoder();
		SecurityAssembler securityAssembler = new SecurityAssembler();
		AuthenticationService authenticationService = new AuthenticationService(credentialRepository,tokenEncoder,securityAssembler);

		ServiceLocator.INSTANCE.register(PasswordPolicy.class,passwordPolicy);
		ServiceLocator.INSTANCE.register(AuthenticationService.class,authenticationService);
		ServiceLocator.INSTANCE.register(ClientRepository.class,clientRepository);
		ServiceLocator.INSTANCE.register(AppointmentRepository.class,appointmentRepository);

	}

	@Override
	public void initialiseService() {

		BarberJsonResource barberResource = BarberResourceContext.create();
		ClientResource clientResource = ClientResourceContext.create();
		ConnectionResource connectionResource = ConnectionResourceContext.create();

		this.resourceContext.add(barberResource);
		this.resourceContext.add(clientResource);
		this.resourceContext.add(connectionResource);

	}
}
