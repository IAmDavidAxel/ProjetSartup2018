package domain.user.client;

import domain.credential.Credential;
import domain.user.password.MismatchedPasswordException;
import domain.user.userProfile.UserProfile;

public class Client {

	private UserProfile userProfile;
	private Credential credential;
	private String email;


	public Client(UserProfile userProfile, Credential credential, String email) {
		this.userProfile = userProfile;
		this.credential = credential;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void updateClientProfile(String firstName, String lastName, String email) {
		if (email != null && !email.isEmpty()) {
			setEmail(email);
		}
		this.userProfile.updateProfile(firstName, lastName);
	}

	public void changePassword(String password) {
		credential.changePassword(password);
	}

	public void verifyPassword(String password) throws MismatchedPasswordException {
		credential.verifyPassword(password);
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public Credential getCredential() {
		return credential;
	}
}
