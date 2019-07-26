package infrastructure.persistence.dto;

public class CredentialDto {

	private String passwordDigest;
	private Long tokenCreationDate;
	private String tokenValue;
	private String accessLevel;

	public String getPasswordDigest() {
		return passwordDigest;
	}

	public void setPasswordDigest(String passwordDigest) {
		this.passwordDigest = passwordDigest;
	}

	public Long getTokenCreationDate() {
		return tokenCreationDate;
	}

	public void setTokenCreationDate(Long tokenCreationDate) {
		this.tokenCreationDate = tokenCreationDate;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
}
