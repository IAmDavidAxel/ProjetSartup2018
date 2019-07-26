package domain.token;

import domain.datetime.DateTime;

public class TokenFactory {
	public Token create() {
		DateTime dateTime = new DateTime();
		return new Token(dateTime);
	}
}
