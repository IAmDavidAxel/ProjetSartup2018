package infrastructure.persistence.assembler;

import domain.user.barber.Barber;
import infrastructure.persistence.dto.BarberDto;
import infrastructure.persistence.dto.CredentialDto;
import infrastructure.persistence.dto.UserProfileDto;

public class BarberAssembler {


	private final CredentialAssembler credentialAssembler;
	private final UserProfileAssembler userProfileAssembler;

	public BarberAssembler(CredentialAssembler credentialAssembler, UserProfileAssembler userProfileAssembler) {

		this.credentialAssembler = credentialAssembler;
		this.userProfileAssembler = userProfileAssembler;
	}

	public BarberDto assemble(Barber barber) {

		BarberDto barberDto = new BarberDto();

		CredentialDto credentialDto = credentialAssembler.assemble(barber.getCredential());

		UserProfileDto userProfileDto = userProfileAssembler.assemble(barber.getUserProfile());


		String phoneNumber = barber.getCellPhoneNumber();

		barberDto.setCredential(credentialDto);
		barberDto.setUserProfile(userProfileDto);
		barberDto.setPhoneNumber(phoneNumber);

		return barberDto;
	}
}
