package api.response.exceptionmapper;

import api.response.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.connection.InvalidTokenServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidTokenServiceExceptionMapper implements ExceptionMapper<InvalidTokenServiceException> {
	@Override
	public Response toResponse(InvalidTokenServiceException exception) {

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withPayload(exception.getMessage())
				.withMessage(MessageDataManager.UNAUTHORIZED_TOKEN_ACCESS)
				.getResponseDto();

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(responseDto)
				.build();

	}
}
