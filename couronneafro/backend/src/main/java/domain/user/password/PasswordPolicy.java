package domain.user.password;

public interface PasswordPolicy {

	boolean isValid(String password);

	boolean matchLength(String notLongEnoughPassword);

	boolean matchPatterns(String password);
}
