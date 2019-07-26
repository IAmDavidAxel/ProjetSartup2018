package api.resources.user.client;

import application.service.exception.ServiceException;
import application.service.security.UserSecurityService;
import application.service.user.client.ClientService;
import api.resources.dto.user.client.ClientDto;
import api.resources.response.ResponseDto;
import api.resources.response.ResponseDtoBuilder;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class ClientJsonResource  implements ClientResource{

	private ClientService clientService;
	private UserSecurityService userSecurityService;

	public ClientJsonResource(ClientService clientService, UserSecurityService userSecurityService){
		this.clientService = clientService;
		this.userSecurityService = userSecurityService;
	}


	@Override
	public Response create(ClientDto clientDto) throws ServiceException {

		clientService.create(clientDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.CLIENT_CREATED)
				.getResponseDtoInstance();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}
}
