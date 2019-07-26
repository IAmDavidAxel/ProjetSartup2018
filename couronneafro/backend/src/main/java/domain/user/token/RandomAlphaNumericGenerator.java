package domain.user.token;

public class RandomAlphaNumericGenerator {

	private static final String ALPHA_NUMERIC_CHAR_SEQ =
			"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";


	public static String generateString(int tokenLength) {

		StringBuilder stringBuilder = new StringBuilder();

		while (tokenLength-- !=0 ){
			int character = (int) (Math.random() * ALPHA_NUMERIC_CHAR_SEQ.length());

			stringBuilder.append(ALPHA_NUMERIC_CHAR_SEQ.charAt(character));

		}
		return stringBuilder.toString();
	}
}
