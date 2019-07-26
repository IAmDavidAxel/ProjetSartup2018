package domain.user.password;

public class JBCryptPasswordPolicy  implements PasswordFactory{

	private PasswordPolicy passwordPolicy;

	public JBCryptPasswordPolicy(PasswordPolicy passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
	}

	@Override
	public Password create(String password) throws IllegalPasswordFormatException {

		if (passwordPolicy.isValid(password)) {
			return new Password(password);
		} else {
			throw new IllegalPasswordFormatException();
		}
	}

}
