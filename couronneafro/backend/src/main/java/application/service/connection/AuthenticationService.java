package application.service.connection;

import api.connection.ConnectionDto;
import application.service.exception.ServiceException;
import domain.user.Credential;
import domain.user.IllegalTokenValidationException;
import domain.user.credential.CredentialRepository;
import domain.user.password.WrongPasswordException;
import domain.user.token.Token;
import domain.user.token.TokenEncoder;
import infrastructure.ObjectNotFoundException;
import infrastructure.client.PersistenceInternalException;

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

		String username = connectionDto.getUsername();
		String password = connectionDto.getPassword();

		try{
			credential = credentialRepository.findByUsername(username);
			credential.verifyPassword(password);
		}catch (ObjectNotFoundException| WrongPasswordException e){
			throw new NotAuthenticatedServiceException();
		}

		Token updatedToken = credential.generateToken();

		try{
			credentialRepository.save(credential,username);
		}catch (PersistenceInternalException e){

			throw  new PersistenceServiceException();
		}

		String accessToken = tokenEncoder.encode(username,updatedToken.getTokenValue());

		long expiresIn = updatedToken.getPolicy().expiresIn();

		return securityAssembler.toTokenDto(accessToken,expiresIn);
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
		}
	}

	public void logout(ConnectionDto connectionDto) throws ServiceException {

		String username = connectionDto.getUsername();

		Credential credential = null;
		try {
			credential = credentialRepository.findByUsername(username);
			credential.invalidateToken();
			credentialRepository.save(credential, username);
		} catch (PersistenceInternalException | ObjectNotFoundException exception) {
			throw new PersistenceInternalErrorServiceException();
		}

	}

	}

