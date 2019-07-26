package application.service.appointment;

import api.appointment.AppointmentDto;
import domain.appointment.Appointment;
import domain.appointment.AppointmentId;
import domain.user.identifier.UserId;

public class AppointmentFactory {


	private AppointmentIdFactory appointmentIdFactory;

	public AppointmentFactory(AppointmentIdFactory appointmentIdFactory) {

		this.appointmentIdFactory = appointmentIdFactory;

	}

	public Appointment create(AppointmentDto appointmentDto, String userId) {

		AppointmentId appointmentId = appointmentIdFactory.create();
		UserId clientId = new UserId(userId);

		String clientUsername = appointmentDto.getUsername();
		String description = appointmentDto.getDescription();


		return new Appointment(appointmentId,clientId,clientUsername,description);
	}
}
