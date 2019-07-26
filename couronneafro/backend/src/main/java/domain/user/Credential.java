package domain.user;

import domain.DateTime;
import domain.user.password.Password;
import domain.user.password.WrongPasswordException;
import domain.user.token.Token;

public class Credential {

	private Password password;
	private AccessLevel accessLevel;
	private Token token;

	public Credential(Password password, AccessLevel accessLevel, Token token) {
		this.password = password;

		this.accessLevel = accessLevel;
		this.token = token;
	}

	public Password getPassword() {
		return password;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public Token getToken() {
		return token;
	}

	public void verifyPassword(String password) throws WrongPasswordException {

		this.password.verify(password);
	}

	public Token generateToken() {

		if (token == null){
			this.token =new Token(new DateTime());
		}

		this.token.generate();
		return token;
	}

	public boolean isValidToken(String decodedToken) throws IllegalTokenValidationException {

		this.token.verifyValue(token);

		return false;
	}

	public void invalidateToken() {

	}
}
