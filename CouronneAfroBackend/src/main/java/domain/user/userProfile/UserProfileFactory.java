package domain.user.userProfile;

public class UserProfileFactory {

	public UserProfile create(UserId userId, String anUsername, String aFirstName, String a_last_nAmE) {
		return new UserProfile(userId,anUsername,aFirstName,a_last_nAmE);
	}
}
