package domain.user.userProfile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileFactoryTest {

	private static final String AN_USERNAME = "BobsBurger";
	private static final String A_FIRST_NAME = "Bob";
	private UserProfileFactory userProfileFactory;
	private UserId userId;
	private static  final String A_LAST_NAmE = "Burger";

	@Before
	public void setUp(){
		userProfileFactory = new UserProfileFactory();
	}

	@Test
	public void whenCreatingANewProfile_thenItIsAnInstanceOfUserProfile()throws Exception{

		Object profileFromFactory = userProfileFactory.create(userId,AN_USERNAME,A_FIRST_NAME,A_LAST_NAmE);
	}

}