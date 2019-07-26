package application.service.user.barber;

import api.resources.user.barber.BarberDto;
import domain.credential.CredentialFactory;
import domain.token.Token;
import domain.token.TokenFactory;
import domain.user.AccessLevel;
import domain.user.barber.BarberFactory;
import domain.user.id.UserIdFactory;
import domain.user.password.Password;
import domain.user.password.PasswordFactory;
import domain.user.userProfile.UserId;
import domain.user.userProfile.UserProfileFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberFactoryTest {

	private static final String AN_USERNAME = "harryPotter";
	private static final String A_FIRSTNAME = "Harry";
	private static final String A_LASTNAME = "Potter";
	private static final String A_PHONE_NUMBER = "581-777-8725";
	private static final String A_PASSWORD = "HarryPotpot32**";
	private BarberFactory barberFactory;
	private BarberDto barberDto;

	@Mock
	private TokenFactory tokenFactory;
	@Mock
	private CredentialFactory credentialFactory;
	@Mock
	private PasswordFactory passwordFactory;
	@Mock
	private UserIdFactory userIdFactory;
	@Mock
	private UserProfileFactory userProfileFactory;
	private Password password;
	private UserId userId;
	private Token token;

	private void setUpBarberDto(){

		barberDto = new BarberDto();

		barberDto.setUsername(AN_USERNAME);
		barberDto.setFirstName(A_FIRSTNAME);
		barberDto.setLastName(A_LASTNAME);
		barberDto.setCellPhoneNumber(A_PHONE_NUMBER);
		barberDto.setPasswordValue(A_PASSWORD);
	}

	@Before
	public void setUp() throws Exception{
		setUpBarberDto();

		barberFactory = new BarberFactory(passwordFactory,tokenFactory,credentialFactory,userIdFactory,userProfileFactory);

		willReturn(password).given(passwordFactory).create(A_PASSWORD);

	}

	@Test
	public void whenCreatingANewBarber_thenDelegateToPAsswordFactory()throws Exception{

		barberFactory.create(barberDto);

		verify(passwordFactory).create(A_PASSWORD);
	}

	@Test
	public void whenCreatingANewBarber_thenDelegateTokenCreationToFactory()throws Exception{

		barberFactory.create(barberDto);

		verify(tokenFactory).create();
	}

	@Test
	public void whenCreatingANewBarber_thenDelegateUserIdCreationToFactory()throws Exception{

		barberFactory.create(barberDto);

		verify(userIdFactory).create();
	}

	@Test
	public void whenCreatingANewBarber_thenDelegateProfileCreationToFactory()throws Exception{

		willReturn(userId).given(userIdFactory).create();
		willReturn(token).given(tokenFactory).create();

		barberFactory.create(barberDto);

		verify(credentialFactory).create(password,token, AccessLevel.BARBER);

	}



}
