package domain.token.encoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TokenEncoder {

	private String salt;
	private String token;


	public TokenEncoder() {
		this.salt = null;
		this.token = null;
	}

	public String getSalt() {
		return salt;
	}

	public String getToken() {
		return token;
	}

	public void decode(String accessToken) throws ParsingTokenEncoderException {
		try{
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] decodedAccess = decoder.decode(accessToken);
			String decodedToken = new String(decodedAccess);
			parse(decodedToken);
		}catch (IllegalArgumentException exception){
			throw new ParsingTokenEncoderException();
		}

	}

	public String encode(String username, String token) {

		String toEncode = token + "." + username;
		Base64.Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(toEncode.getBytes(StandardCharsets.UTF_8));
	}

	private void parse(String decodedToken) throws ParsingTokenEncoderException {
		if (decodedToken.contains(".")){
			token = decodedToken.split("\\.")[0];
			salt = decodedToken.split("\\.")[1];
		} else {
			throw new ParsingTokenEncoderException();
		}
	}
}
