package api.client;

import api.response.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.client.ClientService;
import application.service.exception.ServiceException;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class ClientJsonResource implements ClientResource {


	private ClientService clientService;

	public ClientJsonResource(ClientService clientService) {

		this.clientService = clientService;
	}

	@Override
	public Response create(ClientDto clientDto) throws ServiceException {

		clientService.create(clientDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.CLIENT_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}

}
