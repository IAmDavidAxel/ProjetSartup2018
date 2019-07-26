package api.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectionDto {

	@JsonProperty(value = "username")
	public String username;
	@JsonProperty(value = "password")
	public  String password;

	public ConnectionDto(String username, String password) {
		this.username = username;
		this.password = password;
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
}
