package domain.user.password;

public class MissingPasswordPolicyMode extends RuntimeException {

	public MissingPasswordPolicyMode() {
		super("Missing password mode in configuration");
	}
}
