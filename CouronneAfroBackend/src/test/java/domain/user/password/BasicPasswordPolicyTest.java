package domain.user.password;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicPasswordPolicyTest {

	private static final String VALID_LENGTH_PASSWORD = "AquamanBest";
	private static final String VALID_PATTERN = "AQuamanBest2020**";
	private BasicPasswordPolicy basicPasswordPolicy;

	@Before
	public void setUp(){
		basicPasswordPolicy = new BasicPasswordPolicy();
	}

	@Test
	public void whenTestingPasswordLengthIsOk_thenReturnTrue()throws Exception{

	boolean validLength = 	basicPasswordPolicy.isValidLength(VALID_LENGTH_PASSWORD);

	assertTrue(validLength);
	}

	@Test
	public void whenTestingAGoodPatternPassword_thenReturnTrue()throws Exception{

		boolean validPattern = basicPasswordPolicy.isValidPattern(VALID_PATTERN);

		assertTrue(validPattern);
	}

}
