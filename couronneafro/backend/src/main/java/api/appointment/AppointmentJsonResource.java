package api.appointment;

import api.response.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.client.ClientService;
import application.service.exception.ServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;


public class AppointmentJsonResource implements AppointmentResource {

	private ClientService clientService;

	public AppointmentJsonResource(ClientService clientService) {
		this.clientService = clientService;
	}


	@Override
	public Response makeAppointment(AppointmentDto appointmentDto)  throws ServiceException {

		clientService.makeAppointment(appointmentDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withMessage(MessageDataManager.SUCCESS_RESPONSE)
				.withPayload(MessageDataManager.APPOINTMENT_MADE)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}

	@Override
	public Response makeHairAppointment(HairAppointmentDto hairAppointmentDto) throws ServiceException {

		clientService.makeHairAppointment(hairAppointmentDto);

		return null;
	}


}
