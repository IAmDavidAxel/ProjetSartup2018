package domain.appointment;

import domain.user.identifier.UserId;

public class Appointment {

	private AppointmentId appointmentId;
	private UserId userId;
	private String clientUsername;
	private String description;

	public Appointment(AppointmentId appointmentId, UserId userId, String clientUsername, String description) {
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.clientUsername = clientUsername;
		this.description = description;
	}

	public String getClientUsername() {
		return clientUsername;
	}


	public String getDescription() {
		return description;
	}


	public String getClientId() {
		return userId.getIdValue();
	}

	public String getId() {
		return appointmentId.getId();
	}
}
