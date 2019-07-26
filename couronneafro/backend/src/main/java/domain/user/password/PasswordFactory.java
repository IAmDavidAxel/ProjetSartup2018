package domain.user.password;

public interface PasswordFactory {
	Password create(String userPassword) throws IllegalPasswordFormatException;
}
