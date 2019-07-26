package domain.user.password;

import org.mindrot.jbcrypt.BCrypt;

public class Password {


	private String passwordDigest;

	public Password(String password) {
		generateFromString(password);
	}

	public Password() {

	}

	public String getDigest() {
		return passwordDigest;
	}

	public void setDigest(String passwordDigest) {
		this.passwordDigest = passwordDigest;
	}

	public void generateFromString(String passwordString) {
		passwordDigest = BCrypt.hashpw(passwordString, BCrypt.gensalt());
	}

	public void verify(String passwordString) throws MismatchedPasswordException {
		boolean valid = BCrypt.checkpw(passwordString, passwordDigest);
		if (!valid) {
			throw new MismatchedPasswordException();
		}
	}

}
