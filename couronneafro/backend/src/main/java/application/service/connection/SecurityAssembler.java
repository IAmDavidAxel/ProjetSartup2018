package application.service.connection;

public class SecurityAssembler {

	public TokenDto toTokenDto(String accessToken, long expiresIn) {

		TokenDto tokenDto = new TokenDto();

		tokenDto.setExpireIn(expiresIn);
		tokenDto.setToken(accessToken);

		return tokenDto;
	}
}
