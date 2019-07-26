package api.resources.user.barber;

import com.fasterxml.jackson.annotation.JsonProperty;
import sun.awt.SunHints;

public class BarberDto {

	@JsonProperty(value = "userName")
	private String username;
	@JsonProperty(value = "firstName")
	private String firstName;
	@JsonProperty(value = "lastName")
	private String lastName;
	@JsonProperty(value = "cellPhoneNumber")
	private String cellPhoneNumber;
	@JsonProperty(value = "password")
	private String passwordValue;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setPasswordValue(String passwordValue) {
		this.passwordValue = passwordValue;
	}

	public String getPasswordValue() {
		return passwordValue;
	}
}
