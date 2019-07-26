package domain.datetime;

import java.time.Instant;

public class DateTime {

	private Instant timeInstant;

	public DateTime() {
		this.timeInstant =Instant.ofEpochMilli(0);
	}

	public DateTime(long tokenCreationDate) {
		setTime(tokenCreationDate);
	}

	public long convertToUnixTime() {
		return timeInstant.toEpochMilli();
	}

	public String convertToDateString() {
		return timeInstant.toString();
	}

	public void setToCurrentTime() {
		this.timeInstant = Instant.now();
	}

	public void setTime(long unixTime) {
		timeInstant = Instant.ofEpochMilli(unixTime);
	}

	public void setTime(String dateTime) {
		timeInstant = Instant.parse(dateTime);
	}


}
