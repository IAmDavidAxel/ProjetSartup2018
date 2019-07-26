package domain.user.userProfile;

import java.util.UUID;

public class UserId {

	private String id;

	public UserId(String id) {
		this.id = id;
	}

	public UserId() {
		generateId();
	}

	private void generateId() {
		id = UUID.randomUUID().toString();
	}

	public String getIdValue() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
