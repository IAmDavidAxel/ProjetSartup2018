package server;

import api.response.exceptionmapper.*;
import http.CORSResponseFilter;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.SpringBootConfiguration;
import server.context.Context;
import utility.ApplicationConfiguration;
import utility.PropertyConfiguration;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootConfiguration
public class  EasyCoiffureServer {

	private static final Logger SERVER_LOGGER = Logger.getLogger(EasyCoiffureServer.class.getName());

	private Server server;

	public static void main(String[] args) throws Exception{

		SERVER_LOGGER.info("Loading application configuration parameters");

		PropertyConfiguration property = new PropertyConfiguration(ApplicationConfiguration.PROPERTIES_FILE_NAME);
		property.initialize();
		property.apply();

		SERVER_LOGGER.info("Loading application context parameters registering and initializing services");
		Context applicationContext = Context.create();
		applicationContext.registerService();
		applicationContext.initialiseService();

		EasyCoiffureServer server = new EasyCoiffureServer();
		server.start(ApplicationConfiguration.serverPort, applicationContext);
		server.join();


	}



	private void start(int serverPort, Context applicationContext) throws Exception {

		server = new Server(serverPort);
		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

		ContextHandlerCollection contextHandlerCollection =configureJersey(servletContextHandler,applicationContext);
		server.setHandler(contextHandlerCollection);

		try{
			server.start();
			SERVER_LOGGER.info("Server started at " + server.getURI());

		}catch (Exception e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
		}finally {
			tryStopServer();
		}

	}

	private void join() {
		try {
			server.join();
		}catch (Exception e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
		}

	}


	private void tryStopServer() {
		try {
			server.destroy();
		}catch (Exception e){
			return;
		}
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception exception) {
			Logger.getGlobal().log(Level.SEVERE, exception.getMessage());
		}
	}



	public ContextHandlerCollection configureJersey(ServletContextHandler servletContextHandler, Context applicationContext) throws Exception {
	servletContextHandler.setContextPath("/api/");

		SERVER_LOGGER.info("Registering Resources");
		ResourceConfig resourceConfig =ResourceConfig.forApplication( new Application(){
			@Override
			public Set<Object>getSingletons(){
				HashSet<Object> resources = new HashSet<>();
				resources.addAll(applicationContext.getResourceContext());
				return resources;
			}

		}).register(IllegalPasswordFormatServiceExceptionMapper.class)
			.register(InvalidTokenServiceExceptionMapper.class)
			.register(MismatchedPasswordServiceExceptionMapper.class)
			.register(EntityCreationServiceExceptionMapper.class)
			.register(PersistenceInternalServiceExceptionMapper.class)
		.register(CORSResponseFilter.class);

		ServletContainer servletContainer = new ServletContainer(resourceConfig);
		ServletHolder servletHolder = new ServletHolder(servletContainer);
		servletContextHandler.addServlet(servletHolder,"/*");


		//setup http server
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[]{servletContextHandler});

		return contexts;
	}

}
