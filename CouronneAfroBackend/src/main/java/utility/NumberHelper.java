package utility;

import java.math.BigDecimal;

public class NumberHelper {

	public static Long toLong(Number number) {
		if (number == null) {
			return null;
		} else {
			return new Long(number.longValue());
		}
	}

	public static BigDecimal toBigDecimal(Number number) {
		if (number == null) {
			return null;
		} else {
			return new BigDecimal(number.toString());
		}
	}
}
