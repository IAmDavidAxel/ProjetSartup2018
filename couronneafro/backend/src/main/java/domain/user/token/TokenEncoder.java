package domain.user.token;

public interface TokenEncoder {

	String getSalt();

	String getToken();

	String encode(String username, String tokenValue);

	void decode(String accessToken) throws ParsingTokenEncoderException;
}
