package api.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDto {

	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "cellphone")
	private String cellPhone;
	@JsonProperty(value = "email")
	private String email;
	@JsonProperty(value = "username")
	private String username;
	@JsonProperty(value = "password")
	private String password;
	@JsonProperty(value = "last_name")
	private String lastName;
	@JsonProperty(value = "address")
	private String address;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
