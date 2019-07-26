package server.database.configuration;

@SuppressWarnings("serial")
public class DatabaseCreationException extends Exception {

	public DatabaseCreationException() {
		super("Can't load database schema");
	}

}
