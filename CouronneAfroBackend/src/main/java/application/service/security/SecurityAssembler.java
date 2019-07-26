package application.service.security;

import api.dto.TokenDto;

public class SecurityAssembler {

	public TokenDto toTokenDto(String accessToken, long expiresIn){
		TokenDto tokenDto = new TokenDto();
		tokenDto.setToken(accessToken);
		tokenDto.setExpireIn(expiresIn);

		return tokenDto;
	}
}
