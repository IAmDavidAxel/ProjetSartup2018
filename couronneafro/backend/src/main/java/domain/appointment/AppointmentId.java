package domain.appointment;

import java.util.UUID;

public class AppointmentId {

	private String id;

	public AppointmentId(){
		generateId();
	}

	private void generateId() {
		this.id= UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
