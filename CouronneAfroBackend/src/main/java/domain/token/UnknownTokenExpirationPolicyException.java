package domain.token;

public class UnknownTokenExpirationPolicyException extends RuntimeException {

	public UnknownTokenExpirationPolicyException(){
		super("no token expiration policy provided");
	}
}
