package domain.user;

import application.service.client.InvalidUserNameException;
import domain.user.password.IllegalPasswordFormatException;

public interface UserFactory<User,UserDto> {

	User create(UserDto creationDto) throws IllegalPasswordFormatException, InvalidUserNameException;
}
