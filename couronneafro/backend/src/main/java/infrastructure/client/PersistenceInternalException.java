package infrastructure.client;

public class PersistenceInternalException extends Exception {

	public PersistenceInternalException(){
		super("un probleme de persistence interne est arrivé");
	}
}
