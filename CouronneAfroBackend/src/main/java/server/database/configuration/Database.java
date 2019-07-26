package server.database.configuration;

import domain.credential.Credential;
import domain.datetime.DateTime;
import domain.token.Token;
import domain.user.AccessLevel;
import domain.user.manager.Manager;
import domain.user.manager.ManagerRepository;
import domain.user.password.Password;
import domain.user.userProfile.UserId;
import domain.user.userProfile.UserProfile;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;
import infrastructure.persistence.exception.PersistenceInternalException;
import utility.datamanager.ApplicationConfiguration;
import utility.servicelocator.ServiceLocator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

	private String schema;
	private Connection connection;

	public void createDatabase(String databaseName) {
		try {
			loadSchema();
			initialiseConnection(databaseName);
			executeSchema();
			addManagerToDatabase();
		} catch (SQLException | IOException | PersistenceInternalException exception) {
			Logger.getGlobal().log(Level.SEVERE, exception.getMessage());
		}
	}

	private void loadSchema() throws IOException {
		byte[] encodedFile = Files.readAllBytes(Paths.get(ApplicationConfiguration.sqliteSchemaFileName));
		schema = new String(encodedFile, StandardCharsets.UTF_8);
	}

	private void initialiseConnection(String databseName) {
		SqliteConnection sqliteConnection = new SqliteConnection(databseName);
		connection = sqliteConnection.getConnection();
	}

	private void executeSchema() throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(schema);
		statement.close();
	}

	private void addManagerToDatabase() throws PersistenceInternalException {
		Manager manager = createManagerFromProperties();
		saveManagerToDatabase(manager);
	}

	private Manager createManagerFromProperties() {
		DateTime dateTime = new DateTime();
		Password password = new Password(ApplicationConfiguration.managerPassword);
		Token token = new Token(dateTime);
		Credential credential = new Credential(password, token, AccessLevel.MANAGER);

		UserId userId = new UserId();
		UserProfile userProfile = new UserProfile(userId, ApplicationConfiguration.managerUsername, null, null);

		return new Manager(userProfile, credential);
	}

	private void saveManagerToDatabase(Manager manager) throws PersistenceInternalException {
		ManagerRepository managerRepository = ServiceLocator.INSTANCE.resolve(ManagerRepository.class);
		managerRepository.save(manager);
	}

	public void deleteDatabase(String databaseName) throws IOException {
		closeConnection();
		Files.deleteIfExists(Paths.get(databaseName));
	}

	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
		}
	}

}
