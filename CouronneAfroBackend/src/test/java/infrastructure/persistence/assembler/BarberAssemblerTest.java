package infrastructure.persistence.assembler;

import domain.credential.Credential;
import domain.user.barber.Barber;
import domain.user.userProfile.UserProfile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class BarberAssemblerTest {

	private BarberAssembler barberAssembler;
	private Barber barber;

	@Mock
	private CredentialAssembler credentialAssembler;
	@Mock
	private UserProfileAssembler userProfileAssembler;

	private Credential credential;
	private UserProfile userProfile;

	@Before
	public void setUp(){
		barberAssembler = new BarberAssembler(credentialAssembler,userProfileAssembler);

		//willReturn(credential).given(barber).getCredential();
		//willReturn(userProfile).given(barber).getUserProfile();
	}

	@Test
	public void when(){
		assertEquals(1,1);
	}



}
