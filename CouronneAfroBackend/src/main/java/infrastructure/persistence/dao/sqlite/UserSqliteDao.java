package infrastructure.persistence.dao.sqlite;

import infrastructure.persistence.dao.sqlite.builder.SqliteBuilder;
import infrastructure.persistence.dto.CredentialDto;
import infrastructure.persistence.dto.UserProfileDto;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;
import infrastructure.persistence.exception.DaoEntityNotFoundException;
import infrastructure.persistence.exception.DaoInternalException;
import utility.NumberHelper;

import java.util.Map;

public class UserSqliteDao implements UserDao {

	protected SqliteConnection connection;

	public UserSqliteDao(SqliteConnection connection) {
		this.connection = connection;
	}


	@Override
	public void save(UserProfileDto userProfileDto, CredentialDto credentialDto) throws DaoInternalException {

		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);

		sqliteBuilder.ReplaceInto("user")
				.Columns("user_id", "username", "password_digest", "token", "token_creation_date", "role")
				.Values(userProfileDto.getUserId(),
						userProfileDto.getUsername(),
						credentialDto.getPasswordDigest(),
						credentialDto.getTokenValue(),
						credentialDto.getTokenCreationDate(),
						credentialDto.getAccessLevel())
				.Execute();

	}

	@Override
	public CredentialDto findCredentialByUsername(String username) throws DaoInternalException, DaoEntityNotFoundException {

		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);
		Map<String, Object> result = sqliteBuilder
				.Select("password_digest", "token", "token_creation_date", "role")
				.From("user")
				.Where("username", "=", username)
				.FetchOne();

		CredentialDto credentialsDto = createCredentialDto(result);

		return credentialsDto;

	}

	@Override
	public void saveCredential(CredentialDto credentialDto, String username) throws DaoInternalException {

		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);
		sqliteBuilder.Update("user")
				.Columns("password_digest", "token", "token_creation_date", "role")
				.Values(credentialDto.getPasswordDigest(),
						credentialDto.getTokenValue(),
						credentialDto.getTokenCreationDate(),
						credentialDto.getAccessLevel())
				.Where("username", "=", username)
				.Execute();

	}

	private CredentialDto createCredentialDto(Map<String, Object> result) {
		String accessLevelValue = (String) result.get("role");
		String tokenValue = (String) result.get("token");
		String passwordDigest = (String) result.get("password_digest");
		Long tokenCreationDate = NumberHelper.toLong((Number) result.get("token_creation_date"));

		CredentialDto credentialsDto = new CredentialDto();
		credentialsDto.setAccessLevel(accessLevelValue);
		credentialsDto.setPasswordDigest(passwordDigest);
		credentialsDto.setTokenCreationDate(tokenCreationDate);
		credentialsDto.setTokenValue(tokenValue);

		return credentialsDto;
	}

	@Override
	public void delete(UserProfileDto userProfileDto) throws DaoInternalException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);
		sqliteBuilder.Delete()
				.From("user")
				.Where("username", "=", userProfileDto.getUsername())
				.Execute();
	}

	@Override
	public boolean existById(String userId) throws DaoInternalException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);
		int rowCount = sqliteBuilder.SelectCount()
				.From("user")
				.Where("user_id", "=", userId)
				.FetchCount();

		return rowCount > 0;
	}

	@Override
	public boolean existByUsername(String username) throws DaoInternalException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);
		int rowCount = sqliteBuilder.SelectCount()
				.From("user")
				.Where("username", "=", username)
				.FetchCount();

		return rowCount > 0;
	}
}
