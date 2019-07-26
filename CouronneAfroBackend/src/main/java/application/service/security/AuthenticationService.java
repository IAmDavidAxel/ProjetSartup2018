package application.service.security;

import api.dto.ConnectionDto;
import api.dto.TokenDto;
import application.service.exception.ServiceException;
import domain.credential.Credential;
import domain.credential.CredentialRepository;
import domain.token.IllegalTokenValidationException;
import domain.token.Token;
import domain.token.encoder.TokenEncoder;
import domain.user.password.MismatchedPasswordException;
import infrastructure.persistence.exception.PersistenceInternalException;

public class AuthenticationService {

	private CredentialRepository credentialRepository;
	private TokenEncoder tokenEncoder;
	private SecurityAssembler securityAssembler;

	public AuthenticationService(CredentialRepository credentialRepository, TokenEncoder tokenEncoder, SecurityAssembler securityAssembler) {
		this.credentialRepository = credentialRepository;
		this.tokenEncoder = tokenEncoder;
		this.securityAssembler = securityAssembler;
	}

	public TokenDto authenticate(ConnectionDto connectionDto) throws ServiceException {
		Credential credential;

		final String username = connectionDto.getUsername();
		final String password = connectionDto.getPassword();

		try {
			credential = credentialRepository.findByUsername(username);
			credential.verifyPassword(password);
		} catch (ObjectNotFoundException | MismatchedPasswordException exception) {
			throw new NotAuthenticatedServiceException();
		} catch (PersistenceInternalException exception) {
			throw new PersistenceInternalErrorServiceException();
		}

		Token updatedToken = credential.generateToken();

		try {
			credentialRepository.saveCredential(credential, username);
		} catch (PersistenceInternalException exception) {
			throw new PersistenceInternalErrorServiceException();
		}

		String accessToken = tokenEncoder.encode(username, updatedToken.getTokenValue());

		return securityAssembler.toTokenDto(accessToken, updatedToken.getPolicy().expiresIn());
	}

	public boolean validateToken(String accessToken) throws ServiceException {
		try {
			tokenEncoder.decode(accessToken);
			String username = tokenEncoder.getSalt();
			String decodedToken = tokenEncoder.getToken();

			Credential credential = credentialRepository.findByUsername(username);

			return credential.isValidToken(decodedToken);
		} catch (IllegalTokenValidationException | ObjectNotFoundException exception) {
			throw new InvalidTokenServiceException();
		} catch (PersistenceInternalException exception) {
			throw new PersistenceInternalErrorServiceException();
		}
	}

	public void logout(ConnectionDto connectionDto) throws ServiceException {
		String username = connectionDto.getUsername();

		Credential credential = null;
		try {
			credential = credentialRepository.findByUsername(username);
			credential.invalidateToken();
			credentialRepository.saveCredential(credential, username);
		} catch (PersistenceInternalException | ObjectNotFoundException exception) {
			throw new PersistenceInternalErrorServiceException();
		}

	}



}
