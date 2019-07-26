package domain.user.barber;

import domain.user.client.Client;

public class Barber {

	private String name;
	private String lastName;
	private String password;
	private String address;
	private String username;

	public Barber(String name, String lastName, String password, String address, String username) {
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		this.username = username;
	}

	public String getName() {
		return name;
	}


	public String getLastName() {
		return lastName;
	}


	public String getPassword() {
		return password;
	}


	public String getAddress() {
		return address;
	}

	public String getUsername() {
		return username;
	}

	public void assign(Client client) {

	}
}
