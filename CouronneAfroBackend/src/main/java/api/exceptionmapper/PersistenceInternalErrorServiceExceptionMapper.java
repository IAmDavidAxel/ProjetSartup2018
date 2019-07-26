package api.exceptionmapper;

import api.resources.response.ResponseDto;
import api.resources.response.ResponseDtoBuilder;
import application.service.security.PersistenceInternalErrorServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class PersistenceInternalErrorServiceExceptionMapper implements ExceptionMapper<PersistenceInternalErrorServiceException> {
	@Override
	public Response toResponse(PersistenceInternalErrorServiceException exception) {

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withPayload(exception.getMessage())
				.withMessage(MessageDataManager.INTERNAL_SERVER_ERROR)
				.getResponseDtoInstance();

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(responseDto)
				.build();

	}
}
