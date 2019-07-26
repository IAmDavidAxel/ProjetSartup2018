package domain;

import java.time.Instant;

public class DateTime {

	private Instant instant;

	public DateTime() {
		instant = Instant.ofEpochMilli(0);
	}

	public DateTime(long tokenCreationDate) {

		setTime(tokenCreationDate);
	}

	public void setTime(long unixTime){
		instant = Instant.ofEpochMilli(unixTime);
	}

	public void setTime(String dateTime){
		instant = Instant.parse(dateTime);
	}


	public void setToCurrentTime() {
		instant = Instant.now();
	}

	public long convertToUnixTime() {

		return instant.toEpochMilli();
	}
}
