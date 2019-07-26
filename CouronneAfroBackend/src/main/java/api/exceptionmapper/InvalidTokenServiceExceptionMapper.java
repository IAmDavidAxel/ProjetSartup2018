package api.exceptionmapper;

import api.resources.response.ResponseDto;
import api.resources.response.ResponseDtoBuilder;
import application.service.security.InvalidTokenServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class InvalidTokenServiceExceptionMapper implements ExceptionMapper<InvalidTokenServiceException> {
	@Override
	public Response toResponse(InvalidTokenServiceException exception) {

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withPayload(exception.getMessage())
				.withMessage(MessageDataManager.UNAUTHORIZED_TOKEN_ACCESS)
				.getResponseDtoInstance();

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(responseDto)
				.build();

	}
}
