package domain.user;

public class UserProfileFactory {

	public UserProfile create(String aName, String lastName, String username, String address, String cellphone) {

		return new UserProfile(aName,lastName,username,address,cellphone);
	}
}
