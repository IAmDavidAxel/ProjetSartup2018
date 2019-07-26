package domain.credential;

import domain.datetime.DateTime;
import domain.token.IllegalTokenValidationException;
import domain.token.Token;
import domain.user.AccessLevel;
import domain.user.password.MismatchedPasswordException;
import domain.user.password.Password;

public class Credential {


	private  Password password;
	private  Token token;
	private  AccessLevel accessLevel;

	public Credential(Password password, Token token, AccessLevel accessLevel) {
		this.password = password;
		this.token = token;
		this.accessLevel = accessLevel;
	}


	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public void verifyPassword(String password) throws MismatchedPasswordException {
		this.password.verify(password);
	}

	public Token generateToken() {
		if (token == null) {
			this.token = new Token(new DateTime());
		}
		this.token.generate();
		return token;
	}

	public void hasAccessLevel(AccessLevel accessLevel) throws InvalidAccessLevelException {
		if (this.accessLevel != accessLevel) {
			throw new InvalidAccessLevelException();
		}
	}

	public void changePassword(String password) {
		this.password.generateFromString(password);
	}

	public boolean isValidToken(String token) throws IllegalTokenValidationException {
		this.token.verifyValue(token);

		return false;
	}

	public void invalidateToken() {
		token.invalidate();
	}

	public Boolean haveAccessTo(AccessLevel accessLevel) {
		return this.accessLevel == accessLevel;
	}


}
