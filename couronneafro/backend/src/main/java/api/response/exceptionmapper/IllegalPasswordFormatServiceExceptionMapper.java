package api.response.exceptionmapper;

import api.response.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.client.IllegalPasswordFormatServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalPasswordFormatServiceExceptionMapper  implements ExceptionMapper<IllegalPasswordFormatServiceException> {

	@Override
	public Response toResponse(IllegalPasswordFormatServiceException e) {

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withMessage(MessageDataManager.PASSWORD_POLICY_VIOLATION)
				.getResponseDto();

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(responseDto)
				.build();

	}
}
