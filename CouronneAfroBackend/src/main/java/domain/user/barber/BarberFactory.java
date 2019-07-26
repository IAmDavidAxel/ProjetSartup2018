package domain.user.barber;

import api.resources.user.barber.BarberDto;
import domain.credential.Credential;
import domain.credential.CredentialFactory;
import domain.token.Token;
import domain.token.TokenFactory;
import domain.user.AccessLevel;
import domain.user.barber.Barber;
import domain.user.client.UserFactory;
import domain.user.id.UserIdFactory;
import domain.user.password.IllegalPasswordFormatException;
import domain.user.password.Password;
import domain.user.password.PasswordFactory;
import domain.user.userProfile.UserId;
import domain.user.userProfile.UserProfile;
import domain.user.userProfile.UserProfileFactory;

public class BarberFactory  implements UserFactory<Barber,BarberDto> {


	private  PasswordFactory passwordFactory;
	private  TokenFactory tokenFactory;
	private  CredentialFactory credentialFactory;
	private  UserIdFactory userIdFactory;
	private  UserProfileFactory userProfileFactory;

	public BarberFactory(PasswordFactory passwordFactory, TokenFactory tokenFactory, CredentialFactory credentialFactory, UserIdFactory userIdFactory, UserProfileFactory userProfileFactory) {


		this.passwordFactory = passwordFactory;
		this.tokenFactory = tokenFactory;
		this.credentialFactory = credentialFactory;
		this.userIdFactory = userIdFactory;
		this.userProfileFactory = userProfileFactory;
	}

	@Override
	public Barber create(BarberDto barberDto) throws IllegalPasswordFormatException {

		String passwordFromDto = barberDto.getPasswordValue();
		String username = barberDto.getUsername();
		String lastName = barberDto.getLastName();
		String firsrname = barberDto.getFirstName();
		String cellPhoneNumber = barberDto.getCellPhoneNumber();


		Password password = passwordFactory.create(passwordFromDto);
		Token token = tokenFactory.create();
		UserId userId = userIdFactory.create();

		UserProfile userProfile = userProfileFactory.create(userId,username,firsrname,lastName);
		Credential credential = credentialFactory.create(password,token, AccessLevel.BARBER);


		return new Barber(userProfile,credential,cellPhoneNumber);
	}
}

