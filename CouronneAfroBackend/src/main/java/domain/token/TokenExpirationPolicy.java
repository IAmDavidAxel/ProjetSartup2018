package domain.token;

public enum TokenExpirationPolicy {

	// 24 Hours
	SHORT_TERM(3600),
	// 3 days
	MID_TERM(259200),
	// One week
	LONG_TERM(604800);

	// Internal state
	private long expiresIn;

	// Constructor
	TokenExpirationPolicy(final long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public long expiresIn() {
		return expiresIn;
	}

	public static TokenExpirationPolicy expirationPolicy(String policy) {
		TokenExpirationPolicy tokenExpirationPolicy;
		switch (policy) {
			case "midterm":
				tokenExpirationPolicy = TokenExpirationPolicy.MID_TERM;
				break;
			case "shortterm":
				tokenExpirationPolicy = TokenExpirationPolicy.SHORT_TERM;
				break;
			case "longterm":
				tokenExpirationPolicy = TokenExpirationPolicy.LONG_TERM;
				break;
			default:
				throw new UnknownTokenExpirationPolicyException();
		}
		return tokenExpirationPolicy;
	}
}
