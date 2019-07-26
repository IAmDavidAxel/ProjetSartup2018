package infrastructure.persistence.assembler;

import domain.user.userProfile.UserId;
import domain.user.userProfile.UserProfile;
import infrastructure.persistence.dto.UserProfileDto;

public class UserProfileAssembler {

	public UserProfileDto assemble(UserProfile userProfile) {
		UserProfileDto profileDto = new UserProfileDto();
		profileDto.setUserId(userProfile.getUserId().getIdValue());
		profileDto.setUsername(userProfile.getUsername());
		profileDto.setFirstName(userProfile.getFirstName());
		profileDto.setLastName(userProfile.getLastName());

		return profileDto;
	}

	public UserProfile assemble(UserProfileDto userProfileDto) {
		UserId userId = new UserId();
		userId.setId(userProfileDto.getUserId());
		String username = userProfileDto.getUsername();
		String firstName = userProfileDto.getFirstName();
		String lastName = userProfileDto.getLastName();

		UserProfile userProfile = new UserProfile(userId, username, firstName, lastName);

		return userProfile;
	}
}
