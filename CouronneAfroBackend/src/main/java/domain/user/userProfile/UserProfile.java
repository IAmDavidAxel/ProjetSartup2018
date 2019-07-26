package domain.user.userProfile;

public class UserProfile {
	private UserId userId;
	private String username;
	private String firstName;
	private String lastName;

	public UserProfile(UserId userId, String username, String firstName, String lastName) {
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void updateProfile(String firstName, String lastName) {

		if (isValidAttribute(firstName)) {
			setFirstName(firstName);
		}
		if (isValidAttribute(lastName)) {
			setLastName(lastName);
		}
	}

	private boolean isValidAttribute(String attribute) {
		return attribute != null && !attribute.isEmpty();
	}
}
