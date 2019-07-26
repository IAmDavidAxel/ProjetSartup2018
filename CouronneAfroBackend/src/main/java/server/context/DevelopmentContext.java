package server.context;

import api.resources.user.barber.BarberResource;
import api.resources.user.client.ClientResource;
import application.service.security.AccessLevelService;
import application.service.security.AuthenticationService;
import application.service.security.SecurityAssembler;
import domain.credential.CredentialRepository;
import domain.token.encoder.TokenEncoder;
import domain.user.barber.BarberRepository;
import domain.user.client.ClientRepository;
import domain.user.manager.ManagerRepository;
import domain.user.password.PasswordPolicy;
import domain.user.password.PasswordPolicyFactory;
import infrastructure.persistence.assembler.*;
import infrastructure.persistence.dao.*;
import infrastructure.persistence.dao.sqlite.UserDao;
import infrastructure.persistence.dao.sqlite.UserSqliteDao;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;
import infrastructure.persistence.entitymanager.sqlite.SqliteEntityManager;
import infrastructure.persistence.repository.BarberSqliteRepository;
import infrastructure.persistence.repository.SqliteCredentialRepository;
import infrastructure.persistence.repository.SqliteManagerRepository;
import infrastructure.persistence.repository.sqlite.SqliteClientRepository;
import server.context.resourceContext.BarberResourceContext;
import server.context.resourceContext.ClientResourceContext;
import utility.datamanager.ApplicationConfiguration;
import utility.servicelocator.ServiceLocator;

public class DevelopmentContext extends Context {

	private String databaseName;

	public DevelopmentContext() {
		this.databaseName = ApplicationConfiguration.sqliteDbName;
	}

	public DevelopmentContext(String databaseName) {
		this.databaseName = databaseName;
	}




	@Override
	public void registerServices() {


		/**
		 * Register persistence infrastructure services
		 */
		CredentialAssembler credentialAssembler = new CredentialAssembler();
		UserProfileAssembler userProfileAssembler = new UserProfileAssembler();
		ClientAssembler clientAssembler = new ClientAssembler(credentialAssembler, userProfileAssembler);
		ManagerAssembler managerAssembler = new ManagerAssembler(credentialAssembler,userProfileAssembler);
		BarberAssembler barberAssembler = new BarberAssembler(credentialAssembler,userProfileAssembler);

		SqliteConnection connection = new SqliteConnection(databaseName);
		ServiceLocator.INSTANCE.register(SqliteConnection.class, connection);

		UserDao userDao = new UserSqliteDao(connection);
		ClientDao clientDao = new ClientSqliteDAo(connection);
		ManagerDao managerDao = new ManagerSqliteDao(connection);
		BarberDao barberDao = new BarberSqliteDao(connection);


		SqliteEntityManager entityManager = new SqliteEntityManager(connection);
		SqliteCredentialRepository credentialRepository = new SqliteCredentialRepository(credentialAssembler, userDao);
		SqliteClientRepository clientRepository = new SqliteClientRepository(clientAssembler, clientDao);
		SqliteManagerRepository managerRepository = new SqliteManagerRepository(managerAssembler, managerDao);
		BarberRepository barberRepository = new BarberSqliteRepository(barberAssembler,barberDao,entityManager);

		ServiceLocator.INSTANCE.register(CredentialRepository.class, credentialRepository);
		ServiceLocator.INSTANCE.register(ClientRepository.class, clientRepository);
		ServiceLocator.INSTANCE.register(ManagerRepository.class, managerRepository);
		ServiceLocator.INSTANCE.register(BarberRepository.class,barberRepository);


		/**
		 * Register Security services
		 */
		PasswordPolicy passwordPolicy = PasswordPolicyFactory.create(ApplicationConfiguration.passwordPolicyMode);
		TokenEncoder tokenEncoder = new TokenEncoder();
		SecurityAssembler securityAssembler = new SecurityAssembler();

		AuthenticationService authenticationService = new AuthenticationService(credentialRepository, tokenEncoder, securityAssembler);

		AccessLevelService accessLevelService = new AccessLevelService(credentialRepository);

		ServiceLocator.INSTANCE.register(PasswordPolicy.class, passwordPolicy);
		ServiceLocator.INSTANCE.register(AuthenticationService.class, authenticationService);
		ServiceLocator.INSTANCE.register(AccessLevelService.class, accessLevelService);

	}

	@Override
	public void initializeResource() {

		ClientResource clientResource = ClientResourceContext.create();
		BarberResource barberResource = BarberResourceContext.create();

		this.resourcesContext.add(clientResource);
		this.resourcesContext.add(barberResource);

	}


}
