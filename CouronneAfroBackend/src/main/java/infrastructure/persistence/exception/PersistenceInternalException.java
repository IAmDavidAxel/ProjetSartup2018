package infrastructure.persistence.exception;

public class PersistenceInternalException extends Exception {


	public PersistenceInternalException() {
		super("An internal persistence error occurred.");
	}

}
