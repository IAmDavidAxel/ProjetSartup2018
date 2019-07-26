package domain.user.client;

import domain.user.password.IllegalPasswordFormatException;

public interface UserFactory<User, UserDto> {

	User create(UserDto creationDto) throws IllegalPasswordFormatException, InvalidUserNameException;

}
