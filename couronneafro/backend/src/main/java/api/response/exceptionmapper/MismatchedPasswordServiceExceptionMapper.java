package api.response.exceptionmapper;

import api.response.ResponseDto;
import api.response.ResponseDtoBuilder;
import domain.user.MismatchedPasswordException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MismatchedPasswordServiceExceptionMapper implements ExceptionMapper<MismatchedPasswordException> {


	@Override
	public Response toResponse(MismatchedPasswordException e) {

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withMessage(MessageDataManager.INCORRECT_PASSWORD)
				.getResponseDto();

		return Response.status(Response.Status.FORBIDDEN)
				.entity(responseDto)
				.build();
	}
	}

