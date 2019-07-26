package domain.token;

public class RandomAlphaNumericGenerator {


	private static final String ALPHA_NUMERIC_CHAR_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

	public static String generateAlphaNumericString(int length) {
		StringBuilder stringBuilder = new StringBuilder();

		while (length-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_CHAR_STRING.length());
			stringBuilder.append(ALPHA_NUMERIC_CHAR_STRING.charAt(character));
		}

		return stringBuilder.toString();
	}
}
