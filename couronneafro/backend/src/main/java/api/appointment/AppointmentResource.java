package api.appointment;

import application.service.exception.ServiceException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/appointment")
public interface AppointmentResource {


	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response makeAppointment(AppointmentDto appointmentDto)  throws ServiceException;

	Response makeHairAppointment(HairAppointmentDto hairAppointmentDto) throws ServiceException;
}
