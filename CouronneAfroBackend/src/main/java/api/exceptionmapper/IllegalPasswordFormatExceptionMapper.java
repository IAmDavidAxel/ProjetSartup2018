package api.exceptionmapper;

import api.resources.response.ResponseDto;
import api.resources.response.ResponseDtoBuilder;
import application.service.security.IllegalPasswordFormatServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalPasswordFormatExceptionMapper implements ExceptionMapper<IllegalPasswordFormatServiceException> {


	@Override
	public Response toResponse(IllegalPasswordFormatServiceException exception) {

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withMessage(MessageDataManager.PASSWORD_POLICY_VIOLATION)
				.getResponseDtoInstance();

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(responseDto)
				.build();
	}
}
