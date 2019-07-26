package application.service.hairstyle;

import api.hairstyle.dto.HairstyleDto;
import domain.hairstyle.Hairstyle;
import domain.hairstyle.HairstyleRepository;

public class HairstyleService {

	private HairstyleRepository hairstyleRepository;
	private HairstyleAssembler hairstyleAssembler;

	public HairstyleService(HairstyleRepository hairstyleRepository, HairstyleAssembler hairstyleAssembler) {

		this.hairstyleRepository = hairstyleRepository;
		this.hairstyleAssembler = hairstyleAssembler;
	}

	public void create(HairstyleDto hairstyleDto) {

		Hairstyle hairstyle = hairstyleAssembler.assemble(hairstyleDto);

		hairstyleRepository.save(hairstyle);
	}
}
