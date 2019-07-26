package api.response.exceptionmapper;

import api.response.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.connection.PersistenceInternalErrorServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersistenceInternalServiceExceptionMapper implements ExceptionMapper<PersistenceInternalErrorServiceException> {


	@Override
	public Response toResponse(PersistenceInternalErrorServiceException exception) {

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withPayload(exception.getMessage())
				.withMessage(MessageDataManager.INTERNAL_SERVER_ERROR)
				.getResponseDto();

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(responseDto)
				.build();
	}
}
