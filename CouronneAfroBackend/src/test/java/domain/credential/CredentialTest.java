package domain.credential;

import domain.token.Token;
import domain.user.AccessLevel;
import domain.user.password.Password;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CredentialTest {

	private Credential  credential;

	@Mock
	private Password password;
	@Mock
	private Token token;
	private AccessLevel accessLevel;

	@Before
	public void setUp(){
		credential = new Credential(password,token,accessLevel);
	}

	@Test
	public void ok (){

	}




}