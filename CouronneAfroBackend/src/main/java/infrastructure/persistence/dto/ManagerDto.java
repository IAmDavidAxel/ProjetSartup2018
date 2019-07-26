package infrastructure.persistence.dto;

public class ManagerDto {

	private UserProfileDto userProfileDto;
	private CredentialDto credentialDto;

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
}
