package domain.user.password;

public class MissingPasswordPolicyModeException extends RuntimeException{
	public MissingPasswordPolicyModeException(){
		super("missing password mode in conf");
	}
}
