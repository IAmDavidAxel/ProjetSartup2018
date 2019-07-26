package domain.user.client;

import domain.credential.CredentialFactory;
import domain.token.TokenFactory;
import domain.user.id.UserIdFactory;
import domain.user.password.PasswordFactory;
import domain.user.userProfile.UserProfileFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientFactoryTest {

	private  ClientFactory clientFactory;

	@Mock
	private TokenFactory tokenFactory;
	@Mock
	private CredentialFactory credentialFactory;
	@Mock
	private UserIdFactory userIdFactory;
	@Mock
	private UserProfileFactory userProfileFactory;
	@Mock
	private PasswordFactory passwordFactory;

	@Before
	public void setUp(){

		clientFactory = new ClientFactory(tokenFactory,credentialFactory,userIdFactory,userProfileFactory,passwordFactory);

	}

	@Test
	public void whenCreating_then(){

	}





}