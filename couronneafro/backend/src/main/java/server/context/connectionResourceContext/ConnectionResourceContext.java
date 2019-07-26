package server.context.connectionResourceContext;

import api.connection.ConnectionJsonResource;
import api.connection.ConnectionResource;
import application.service.connection.AuthenticationService;
import utility.ServiceLocator;

public class ConnectionResourceContext {

	public static ConnectionResource create(){

		AuthenticationService authenticationService = ServiceLocator.INSTANCE.resolve(AuthenticationService.class);

		return new ConnectionJsonResource(authenticationService);
	}
}
