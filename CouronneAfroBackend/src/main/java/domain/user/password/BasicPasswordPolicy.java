package domain.user.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicPasswordPolicy implements PasswordPolicy {


	private static final int MINIMUM_PASSWORD_LENGTH = 8;


	@Override
	public boolean isValid(String password) {
		return isValidLength(password) && isValidPattern(password);
	}

	@Override
	public boolean isValidPattern(String password) {
		Pattern passwordPolicyPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#<>_\\$%\\^&\\*]).*)");
		Matcher passwordPatternMatcher = passwordPolicyPattern.matcher(password);

		return passwordPatternMatcher.matches();
	}

	@Override
	public boolean isValidLength(String password) {
		return password.length() >= MINIMUM_PASSWORD_LENGTH;
	}
}
