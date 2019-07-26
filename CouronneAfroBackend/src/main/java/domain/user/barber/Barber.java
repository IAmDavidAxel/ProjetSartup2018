package domain.user.barber;

import domain.credential.Credential;
import domain.user.userProfile.UserProfile;

public class Barber {

	private  UserProfile userProfile;
	private  Credential credential;

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public Credential getCredential() {
		return credential;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	private  String cellPhoneNumber;

	public Barber(UserProfile userProfile, Credential credential, String cellPhoneNumber) {

		this.userProfile = userProfile;
		this.credential = credential;
		this.cellPhoneNumber = cellPhoneNumber;
	}
}
