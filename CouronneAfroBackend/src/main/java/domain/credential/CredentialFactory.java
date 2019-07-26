package domain.credential;

import domain.token.Token;
import domain.user.AccessLevel;
import domain.user.password.Password;

public class CredentialFactory {


	public Credential create(Password password, Token token, AccessLevel accessLevel) {
		return new Credential(password,token,accessLevel);
	}
}
