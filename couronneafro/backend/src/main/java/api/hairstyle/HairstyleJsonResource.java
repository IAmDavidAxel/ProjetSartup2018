package api.hairstyle;

import api.hairstyle.dto.HairstyleDto;
import application.service.hairstyle.HairstyleService;

public class HairstyleJsonResource implements HairstyleResource{

	private HairstyleService hairstyleService;

	public HairstyleJsonResource(HairstyleService hairstyleService) {

		this.hairstyleService = hairstyleService;
	}

	@Override
	public void create(HairstyleDto hairstyleDto) {

		hairstyleService.create(hairstyleDto);
	}
}
