package infrastructure.persistence.assembler;

import domain.credential.Credential;
import domain.user.client.Client;
import domain.user.userProfile.UserProfile;
import infrastructure.persistence.dto.ClientDto;
import infrastructure.persistence.dto.CredentialDto;
import infrastructure.persistence.dto.UserProfileDto;

public class ClientAssembler {

	private CredentialAssembler credentialAssembler;
	private UserProfileAssembler profileAssembler;

	public ClientAssembler(CredentialAssembler credentialAssembler, UserProfileAssembler profileAssembler) {
		this.credentialAssembler = credentialAssembler;
		this.profileAssembler = profileAssembler;
	}

	public ClientDto assemble(Client client) {
		CredentialDto credentialDto = credentialAssembler.assemble(client.getCredential());
		UserProfileDto userProfileDto = profileAssembler.assemble(client.getUserProfile());

		ClientDto clientDto = new ClientDto();
		clientDto.setCredentialDto(credentialDto);
		clientDto.setUserProfileDto(userProfileDto);
		clientDto.setEmail(client.getEmail());

		return clientDto;
	}

	public Client assemble(ClientDto clientDto) {
		String email = clientDto.getEmail();
		UserProfile userProfile = profileAssembler.assemble(clientDto.getUserProfileDto());
		Credential credential = credentialAssembler.assemble(clientDto.getCredentialDto());

		return new Client(userProfile, credential, email);
	}
}
