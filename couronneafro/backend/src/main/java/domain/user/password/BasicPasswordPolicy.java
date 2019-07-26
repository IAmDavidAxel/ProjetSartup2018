package domain.user.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicPasswordPolicy implements PasswordPolicy {

	private static int MINIMUM_LENGTH_PASSWORD = 8;

	@Override
	public boolean matchPatterns(String password) {

		Pattern passwordPolicyPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#<>_\\$%\\^&\\*]).*)");

		Matcher passwordPatternMatcher = passwordPolicyPattern.matcher(password);

		return passwordPatternMatcher.matches();
	}

	@Override
	public boolean isValid(String password) {
		return matchLength(password) && matchPatterns(password);
	}

	@Override
	public boolean matchLength(String passwordLength) {
		return passwordLength.length()>= MINIMUM_LENGTH_PASSWORD;
	}
}
