package api.connection;

import api.response.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.connection.AuthenticationService;
import application.service.connection.TokenDto;
import application.service.exception.ServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class ConnectionJsonResource implements ConnectionResource {

	private AuthenticationService authenticationService;

	public ConnectionJsonResource(AuthenticationService authenticationService) {

		this.authenticationService = authenticationService;
	}

	@Override
	public Response login(ConnectionDto connectionDto) throws ServiceException {

		  TokenDto tokenDto = authenticationService.authenticate(connectionDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withPayload(tokenDto)
				.withMessage(MessageDataManager.LOGIN_SUCCEEDED)
				.getResponseDto();

		return Response.ok().entity(responseDto).build();


	}

	@Override
	public Response logout(ConnectionDto connectionDto) throws ServiceException {

		authenticationService.logout(connectionDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.LOGOUT_SUCCEEDED)
				.getResponseDto();

		return Response.ok().entity(responseDto).build();
	}
}
