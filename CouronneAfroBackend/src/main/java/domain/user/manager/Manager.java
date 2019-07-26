package domain.user.manager;


import domain.credential.Credential;
import domain.user.userProfile.UserProfile;

public class Manager {

	private UserProfile userProfile;
	private Credential credential;

	public Manager(UserProfile userProfile, Credential credential) {
		this.userProfile = userProfile;
		this.credential = credential;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

}
