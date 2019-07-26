package infrastructure.persistence.assembler;

import domain.user.manager.Manager;
import infrastructure.persistence.dto.CredentialDto;
import infrastructure.persistence.dto.ManagerDto;
import infrastructure.persistence.dto.UserProfileDto;

public class ManagerAssembler {
	private final CredentialAssembler credentialAssembler;
	private final UserProfileAssembler userProfileAssembler;

	public ManagerAssembler(CredentialAssembler credentialAssembler, UserProfileAssembler userProfileAssembler) {

		this.credentialAssembler = credentialAssembler;
		this.userProfileAssembler = userProfileAssembler;
	}

	public ManagerDto assemble(Manager manager) {
		CredentialDto credentialDto = credentialAssembler.assemble(manager.getCredential());
		UserProfileDto userProfileDto = userProfileAssembler.assemble(manager.getUserProfile());

		ManagerDto managerDto = new ManagerDto();
		managerDto.setCredentialDto(credentialDto);
		managerDto.setUserProfileDto(userProfileDto);

		return managerDto;
	}
}
