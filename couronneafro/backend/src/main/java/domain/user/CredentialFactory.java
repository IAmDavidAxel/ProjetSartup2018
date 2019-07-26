package domain.user;

import domain.user.password.Password;
import domain.user.token.Token;

public class CredentialFactory {
	public Credential create(Password password, AccessLevel accessLevel, Token token) {

		return new Credential(password,accessLevel,token);

	}
}
