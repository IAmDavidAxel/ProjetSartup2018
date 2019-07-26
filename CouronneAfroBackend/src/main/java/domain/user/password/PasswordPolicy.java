package domain.user.password;

public interface PasswordPolicy {

	boolean isValid(String password);

	boolean isValidPattern(String password);

	boolean isValidLength(String password);
}
