package api.response.exceptionmapper;

import api.response.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.client.EntityCreationServiceException;
import application.service.client.InvalidUserNameException;
import domain.user.password.IllegalPasswordFormatException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityCreationServiceExceptionMapper implements ExceptionMapper<EntityCreationServiceException> {


	@Override
	public Response toResponse(EntityCreationServiceException exception) {

		String payload = "";

		if (exception.getCause() instanceof InvalidUserNameException) {
			payload = MessageDataManager.CLIENT_INVALID_USERNAME;
		}

		if (exception.getCause() instanceof IllegalPasswordFormatException) {
			payload = MessageDataManager.PASSWORD_POLICY_VIOLATION;
		}

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withPayload(payload)
				.withMessage(MessageDataManager.BAD_REQUEST_RESPONSE)
				.getResponseDto();

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(responseDto)
				.build();
	}

}
