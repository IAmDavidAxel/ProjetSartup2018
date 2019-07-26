package utility.servicelocator;

@SuppressWarnings("serial")
public class ServiceAlreadyRegisteredException extends RuntimeException {

	public ServiceAlreadyRegisteredException() {
		super("The provided service is already registered");
	}

}
