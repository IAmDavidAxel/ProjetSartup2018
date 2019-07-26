package domain.user.client;

import domain.user.Credential;
import domain.user.UserProfile;

public class Client {

	private UserProfile userProfile;
	private Credential credential;
	private  String email;

	public Client(UserProfile userProfile, Credential credential, String email) {
		this.userProfile = userProfile;
		this.credential = credential;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public Credential getCredential() {
		return credential;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}
}
