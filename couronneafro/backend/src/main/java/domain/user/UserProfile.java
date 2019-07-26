package domain.user;

import domain.user.identifier.UserId;

public class UserProfile {

	private UserId userId;
	private String name;
	private String lastName;
	private String username;
	private String address;
	private String cellPhone;



	public UserProfile(String name, String lastName, String username, String address, String cellPhone) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.address = address;
		this.cellPhone = cellPhone;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getAddress() {
		return address;
	}

	public String getCellPhone() {
		return cellPhone;
	}
}
