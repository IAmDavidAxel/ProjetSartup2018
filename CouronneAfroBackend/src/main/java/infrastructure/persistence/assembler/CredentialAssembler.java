package infrastructure.persistence.assembler;

import domain.credential.Credential;
import domain.token.Token;
import domain.user.AccessLevel;
import domain.user.password.Password;
import infrastructure.persistence.dto.CredentialDto;

public class CredentialAssembler {

	public CredentialDto assemble(Credential credential) {
		CredentialDto credentialDto = new CredentialDto();
		credentialDto.setAccessLevel(credential.getAccessLevel().toString());
		credentialDto.setPasswordDigest(credential.getPassword().getDigest());

		Token token = credential.getToken();
		if (token == null) {
			credentialDto.setTokenCreationDate(null);
			credentialDto.setTokenValue(null);
		} else {
			credentialDto.setTokenCreationDate(token.getCreationDate().convertToUnixTime());
			credentialDto.setTokenValue(token.getTokenValue());
		}

		return credentialDto;
	}

	public Credential assemble(CredentialDto credentialDto) {
		String accessLevelValue = credentialDto.getAccessLevel();
		AccessLevel accessLevel = AccessLevel.valueOf(accessLevelValue);

		String passwordDigest = credentialDto.getPasswordDigest();
		Password password = new Password();
		password.setDigest(passwordDigest);

		String tokenValue = credentialDto.getTokenValue();
		Long tokenCreationDate = credentialDto.getTokenCreationDate();
		Token token = null;
		if (tokenValue != null && tokenCreationDate != null) {
			token = new Token(credentialDto.getTokenValue(), tokenCreationDate);
		}

		Credential credential = new Credential(password, token, accessLevel);

		return credential;
	}
}
