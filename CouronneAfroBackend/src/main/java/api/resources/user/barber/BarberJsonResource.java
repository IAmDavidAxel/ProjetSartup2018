package api.resources.user.barber;

import api.resources.response.ResponseDto;
import api.resources.response.ResponseDtoBuilder;
import application.service.exception.ServiceException;
import application.service.user.manager.ManagerService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class BarberJsonResource  implements  BarberResource{


	private ManagerService managerService;

	public BarberJsonResource( ManagerService managerService) {

		this.managerService = managerService;
	}

	@Override
	public Response create(BarberDto barberDto) throws ServiceException {

		managerService.create(barberDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.BARBER_CREATED)
				.getResponseDtoInstance();


		return Response.status(Response.Status.CREATED)
				.entity(responseDto)
				.build();
	}
}
