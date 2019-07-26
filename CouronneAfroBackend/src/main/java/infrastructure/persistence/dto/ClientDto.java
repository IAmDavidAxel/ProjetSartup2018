package infrastructure.persistence.dto;

public class ClientDto {

	public UserProfileDto userProfileDto;
	public CredentialDto credentialDto;
	public String email;

	public UserProfileDto getUserProfileDto() {
		return userProfileDto;
	}

	public void setUserProfileDto(UserProfileDto userProfileDto) {
		this.userProfileDto = userProfileDto;
	}

	public CredentialDto getCredentialDto() {
		return credentialDto;
	}

	public void setCredentialDto(CredentialDto credentialDto) {
		this.credentialDto = credentialDto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
