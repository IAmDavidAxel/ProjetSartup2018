package domain.user.token;

public class UnknownTokenExpirationPolicyException extends RuntimeException {

	public UnknownTokenExpirationPolicyException() {
		super("No token expiration policy provided");
	}
}
