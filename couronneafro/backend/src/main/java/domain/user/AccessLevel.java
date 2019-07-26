package domain.user;

public enum AccessLevel {

	CLIENT("CLIENT"),
	MANAGER("MANAGER"),
	BARBER("BARBER");

	private String accessLevel;

	AccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}


	@Override
	public String toString() {
		return accessLevel;
	}
}
