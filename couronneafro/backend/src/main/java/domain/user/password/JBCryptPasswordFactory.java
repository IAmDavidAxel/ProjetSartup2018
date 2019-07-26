package domain.user.password;

public class JBCryptPasswordFactory implements PasswordFactory {

	private PasswordPolicy passwordPolicy;

	public JBCryptPasswordFactory(PasswordPolicy passwordPolicy) {

		this.passwordPolicy = passwordPolicy;
	}

	@Override
	public Password create(String userPassword) throws IllegalPasswordFormatException {

		if(passwordPolicy.isValid(userPassword)){
			return new Password(userPassword);
		}
		else
			throw  new IllegalPasswordFormatException();
	}
}
