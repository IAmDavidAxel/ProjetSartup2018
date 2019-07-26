package domain.user.identifier;

import java.util.UUID;

public class UserId {


	private String id;


	public UserId() {
		setIdValue();
	}

	public UserId(String userId) {
		this.id=userId;
	}

	public String getIdValue() {
		return id;
	}

	public void setIdValue() {

		this.id = UUID.randomUUID().toString();
	}
}
