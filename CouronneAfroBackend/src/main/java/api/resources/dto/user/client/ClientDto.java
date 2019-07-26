package api.resources.dto.user.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.glassfish.jersey.server.JSONP;

public class ClientDto {

	@JsonProperty(value = "first_name")
	private String firstName;
	@JsonProperty(value = "last_name")
	private String lastName;
	@JsonProperty(value = "username")
	private String username;
	@JsonProperty(value = "password")
	private String password;
	@JsonProperty(value = "email")
	private String email;

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

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
