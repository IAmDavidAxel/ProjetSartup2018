package infrastructure.persistence.dto;

public class BarberDto {

	private CredentialDto credential;
	private UserProfileDto userProfile;
	private String phoneNumber;

	public void setCredential(CredentialDto credential) {
		this.credential = credential;
	}

	public CredentialDto getCredential() {
		return credential;
	}

	public void setUserProfile(UserProfileDto userProfile) {
		this.userProfile = userProfile;
	}

	public UserProfileDto getUserProfile() {
		return userProfile;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
