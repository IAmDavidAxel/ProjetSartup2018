package domain.credential;

import domain.token.Token;
import domain.user.AccessLevel;
import domain.user.password.Password;
import domain.credential.Credential;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CredentialFactoryTest {

	private CredentialFactory credentialFactory;

	private Password password;
	@Mock
	private Token token;
	private AccessLevel accessLevel;

	@Before
	public void setUp(){
		credentialFactory = new CredentialFactory();
		password = new Password();
		accessLevel = AccessLevel.BARBER;
	}

	@Test
	public void whenCreatingNewCredential_ThenItIsAnInstanceOfCredential(){

		Object credentialFromFactory = credentialFactory.create(password,token,accessLevel);

		assertTrue(credentialFromFactory instanceof Credential);
	}


}