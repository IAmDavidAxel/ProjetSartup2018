package domain.user.password;

public interface PasswordFactory {

	Password create(String password) throws IllegalPasswordFormatException;
}
