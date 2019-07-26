package domain.user.client;

import api.resources.dto.user.client.ClientDto;
import domain.credential.Credential;
import domain.credential.CredentialFactory;
import domain.token.Token;
import domain.token.TokenFactory;
import domain.user.AccessLevel;
import domain.user.id.UserIdFactory;
import domain.user.password.IllegalPasswordFormatException;
import domain.user.password.Password;
import domain.user.password.PasswordFactory;
import domain.user.userProfile.UserId;
import domain.user.userProfile.UserProfile;
import domain.user.userProfile.UserProfileFactory;

public class ClientFactory implements UserFactory<Client,ClientDto>{


	private  TokenFactory tokenFactory;
	private  CredentialFactory credentialFactory;
	private  UserIdFactory userIdFactory;
	private  UserProfileFactory userProfileFactory;
	private PasswordFactory passwordFactory;

	public ClientFactory(TokenFactory tokenFactory, CredentialFactory credentialFactory, UserIdFactory userIdFactory, UserProfileFactory userProfileFactory, PasswordFactory passwordFactory) {

		this.tokenFactory = tokenFactory;
		this.credentialFactory = credentialFactory;
		this.userIdFactory = userIdFactory;
		this.userProfileFactory = userProfileFactory;
		this.passwordFactory = passwordFactory;
	}

	public Client create(ClientDto clientDto) throws InvalidUserNameException, IllegalPasswordFormatException {
		String firstName = clientDto.getFirstName();
		String lastName = clientDto.getLastName();
		String email = clientDto.getEmail();
		String username = clientDto.getUsername();
		String passwordValue = clientDto.getPassword();

		if (username.equals(email)) {
			throw new InvalidUserNameException(username);
		}

		Password password = passwordFactory.create(passwordValue);
		Token token = tokenFactory.create();
		Credential credential = credentialFactory.create(password, token, AccessLevel.CLIENT);
		UserId userId = userIdFactory.create();
		UserProfile userProfile = userProfileFactory.create(userId, username, firstName, lastName);


		return new Client(userProfile, credential, email);
	}
}
