package application.service.hairstyle;

import api.hairstyle.dto.HairstyleDto;
import domain.hairstyle.Hairstyle;

public class HairstyleAssembler {

	public Hairstyle assemble(HairstyleDto hairstyleDto) {

		String name = hairstyleDto.getName();
		int price = hairstyleDto.getPrice();

		return new Hairstyle(name,price);
	}

	public HairstyleDto assemble(Hairstyle hairstyle) {

		HairstyleDto hairstyleDto = new HairstyleDto();

		int price = hairstyle.getPrice();
		String name = hairstyle.getName();

		hairstyleDto.setPrice(price);
		hairstyleDto.setName(name);

		return hairstyleDto;
	}
}

