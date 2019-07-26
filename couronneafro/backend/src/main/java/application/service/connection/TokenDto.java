package application.service.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDto {

	@JsonProperty(value = "token")
	public String token;

	@JsonProperty(value = "expireIn")
	public long expireIn;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(long expireIn) {
		this.expireIn = expireIn;
	}
}
