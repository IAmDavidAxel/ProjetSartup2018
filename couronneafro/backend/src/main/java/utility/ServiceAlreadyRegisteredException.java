package utility;

public class ServiceAlreadyRegisteredException extends RuntimeException {

	public ServiceAlreadyRegisteredException(){
		super("the service you provided is already registered");
	}
}
