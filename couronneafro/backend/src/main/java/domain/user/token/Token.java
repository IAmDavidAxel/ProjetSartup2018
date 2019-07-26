package domain.user.token;


import domain.DateTime;
import domain.user.IllegalTokenValidationException;
import utility.ApplicationConfiguration;

import java.time.Instant;

public class Token {

	private DateTime createdAt;
	private String tokenValue;
	private ValidationStatus validationStatus;
	private TokenExpirationPolicy policy;

	public Token(DateTime createdAt) {

		this.createdAt = createdAt;
		policy = TokenExpirationPolicy.expirationPolicy(ApplicationConfiguration.tokenExpirationPolicy);
		tokenValue="";
	}

	public Token(String tokenValue, long tokenCreationDate) {

		this.tokenValue = tokenValue;
		createdAt = new DateTime(tokenCreationDate);
		policy = TokenExpirationPolicy.expirationPolicy(ApplicationConfiguration.tokenExpirationPolicy);
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public ValidationStatus getValidationStatus() {
		return validationStatus;
	}

	public TokenExpirationPolicy getPolicy() {
		return policy;
	}

	public void generate() {
		tokenValue = RandomAlphaNumericGenerator.generateString(ApplicationConfiguration.tokenLength);

		validationStatus = ValidationStatus.VALID;
		createdAt.setToCurrentTime();

	}

	public boolean isValid() {
		if (tokenValue.isEmpty() || validationStatus == ValidationStatus.INVALID) {
			return false;
		}
		return true;
	}

	public void checkTokenValidity(String dateString) {
		long providedDate = Instant.parse(dateString).toEpochMilli() / 1000;
		long expireIn = policy.expiresIn();
		long actualExpirationDate = createdAt.convertToUnixTime() / 1000 + expireIn;

		if (actualExpirationDate < providedDate) {
			validationStatus = ValidationStatus.INVALID;
		}
	}


	public void changePolicy(TokenExpirationPolicy tokenExpirationPolicy) {
		policy = tokenExpirationPolicy;
	}

	public void invalidate() {
		validationStatus = ValidationStatus.INVALID;

		// TODO To ameliorate the approach
		tokenValue = "";
	}


	public void verify(String tokenValue) throws IllegalTokenValidationException {

		if (!this.tokenValue.equals(tokenValue)){
			throw new IllegalTokenValidationException();
		}

	}

	public void verifyValue(Token token)  throws IllegalTokenValidationException {

		if(!this.tokenValue.equals(tokenValue)){
			throw new IllegalTokenValidationException();
		}

	}

}
