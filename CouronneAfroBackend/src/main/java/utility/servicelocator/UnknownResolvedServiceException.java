package utility.servicelocator;

@SuppressWarnings("serial")
public class UnknownResolvedServiceException extends RuntimeException {

	public UnknownResolvedServiceException() {
		super("Cannot resolve the service, may be not registered");
	}
}
