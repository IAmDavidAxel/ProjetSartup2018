package domain.user.id;

import domain.user.userProfile.UserId;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserIdFactoryTest {

	private UserIdFactory userIdFactory;

	@Before
	public void setUp(){
		userIdFactory = new UserIdFactory();
	}

	@Test
	public void creatingNewId(){

		Object userId = userIdFactory.create();

		assertTrue(userId instanceof UserId);
	}

	@Test
	public void whenCreatingTwoIds_thenTheSecondOneHasADifferentValue(){
		UserId firstId = userIdFactory.create();

		String idValueFromThefirst = firstId.getIdValue();

		UserId secondId = userIdFactory.create();

		String idValueFromSecond = secondId.getIdValue();

		assertNotEquals(idValueFromSecond,idValueFromThefirst);

	}

}