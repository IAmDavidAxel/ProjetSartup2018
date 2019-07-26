package domain.user.password;

import org.mindrot.jbcrypt.BCrypt;

public class Password {

	private String passwordDigest;

	public Password(String userPassword) {
		generateFromString(userPassword);
	}

	public Password() {
	}

	public void generateFromString(String plainPassword) {
		passwordDigest = BCrypt.hashpw(plainPassword,BCrypt.gensalt());
	}

	public String getPasswordDigest() {
		return passwordDigest;
	}

	public void setPasswordDigest(String passwordDigest) {
		this.passwordDigest = passwordDigest;
	}

	public void verify(String plainPassword) throws WrongPasswordException {

		boolean matchingPassword = BCrypt.checkpw(plainPassword,passwordDigest);

		if (!matchingPassword){
			throw  new WrongPasswordException();
		}

	}
}
