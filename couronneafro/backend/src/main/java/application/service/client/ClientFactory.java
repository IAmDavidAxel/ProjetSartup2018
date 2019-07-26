package application.service.client;

import api.client.ClientDto;
import domain.user.*;
import domain.user.client.Client;
import domain.user.identifier.UserId;
import domain.user.password.IllegalPasswordFormatException;
import domain.user.password.Password;
import domain.user.password.PasswordFactory;
import domain.user.token.Token;
import domain.user.token.TokenFactory;

public class ClientFactory implements  UserFactory<Client, ClientDto>{

	private CredentialFactory credentialFactory;
	private  UserProfileFactory userProfileFactory;
	private TokenFactory tokenFactory;
	private PasswordFactory passwordFactory;


	public ClientFactory(CredentialFactory credentialFactory, UserProfileFactory userProfileFactory, TokenFactory tokenFactory, PasswordFactory passwordFactory) {

		this.credentialFactory = credentialFactory;
		this.userProfileFactory = userProfileFactory;
		this.tokenFactory =tokenFactory;
		this.passwordFactory = passwordFactory;
	}

	public Client create(ClientDto clientDto) throws IllegalPasswordFormatException, InvalidUserNameException {

		String email = clientDto.getEmail();
		String username = clientDto.getUsername();
		String password = clientDto.getPassword();
		String lastName = clientDto.getLastName();
		String name = clientDto.getName();
		String cellphone = clientDto.getCellPhone();
		String address = clientDto.getAddress();

		UserId userId = new UserId();

		if (username.equals(email)){
			throw  new InvalidUserNameException(username);
		}

		UserProfile userProfile = userProfileFactory.create(name,lastName,username,address,cellphone);

		Token token = tokenFactory.create();
		Password passwordFromFactory = passwordFactory.create(password);

		Credential credential = credentialFactory.create(passwordFromFactory, AccessLevel.CLIENT,token);

		return new Client(userProfile,credential,email);
	}

	public ClientDto create(Client client) {

		return null;
	}
}
