package infrastructure.persistence.dao;

import infrastructure.persistence.dao.sqlite.UserSqliteDao;
import infrastructure.persistence.dao.sqlite.builder.SqliteBuilder;
import infrastructure.persistence.dto.ClientDto;
import infrastructure.persistence.dto.CredentialDto;
import infrastructure.persistence.dto.UserProfileDto;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;
import infrastructure.persistence.exception.DaoEntityNotFoundException;
import infrastructure.persistence.exception.DaoInternalException;

import java.util.Map;

public class ClientSqliteDAo extends UserSqliteDao implements ClientDao {

	public ClientSqliteDAo(SqliteConnection sqliteConnection){
		super(sqliteConnection);
	}


	@Override
	public void save(ClientDto clientDto) throws DaoInternalException {
		super.save(clientDto.getUserProfileDto(),clientDto.getCredentialDto());

		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);

		sqliteBuilder.ReplaceInto("client")
				.Columns("client_id", "email", "first_name", "last_name")
				.Values(clientDto.getUserProfileDto().getUserId(),
						clientDto.getEmail(),
						clientDto.getUserProfileDto().getFirstName(),
						clientDto.getUserProfileDto().getLastName())
				.Execute();



	}

	@Override
	public ClientDto findById(String clientId) throws DaoInternalException, DaoEntityNotFoundException {

		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);
		Map<String, Object> result = sqliteBuilder
				.Select("user_id", "username", "email", "first_name", "last_name")
				.From("client")
				.InnerJoin("user")
				.On("user_id", "=", "client_id")
				.Where("client_id", "=", clientId)
				.FetchOne();

		UserProfileDto userProfileDto = createUserProfileDto(result);
		CredentialDto credentialDto = super.findCredentialByUsername(userProfileDto.getUsername());

		return createClientDto(userProfileDto, credentialDto, result);

	}

	@Override
	public void save(UserProfileDto userProfileDto, CredentialDto credentialDto) throws DaoInternalException {

	}

	private UserProfileDto createUserProfileDto(Map<String, Object> result) {
		String userId = (String) result.get("user_id");
		String clientUsername = (String) result.get("username");
		String firstName = (String) result.get("first_name");
		String lastName = (String) result.get("last_name");

		UserProfileDto userProfileDto = new UserProfileDto();
		userProfileDto.setUserId(userId);
		userProfileDto.setUsername(clientUsername);
		userProfileDto.setFirstName(firstName);
		userProfileDto.setLastName(lastName);

		return userProfileDto;
	}

	private ClientDto createClientDto(UserProfileDto userProfileDto, CredentialDto credentialDto, Map<String, Object> result) {
		String email = (String) result.get("email");

		ClientDto clientDto = new ClientDto();
		clientDto.setUserProfileDto(userProfileDto);
		clientDto.setCredentialDto(credentialDto);
		clientDto.setEmail(email);

		return clientDto;
	}

}
