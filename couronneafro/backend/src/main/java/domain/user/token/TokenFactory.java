package domain.user.token;

import domain.DateTime;

public class TokenFactory {

	public Token create() {

		DateTime dateTime = new DateTime();

		return new Token(dateTime);
	}
}
