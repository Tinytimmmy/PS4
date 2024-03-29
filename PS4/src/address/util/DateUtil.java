package address.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper functions for handling dates.
 * 
 * @author Jacques
 */
public class DateUtil {

	/** The date patter that is used for conversion
	 * Alter the string to change the pattern type 
	 */
	private static final String DATE_PATTERN = "dd.MM.yyy";
	
	/** The date formatter */
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	/**
	 * Returns the given date as a well formatted String, the value defined above
	 * {@link DateUtil#DATE_PATTERN} is used.
	 * 
	 * @param date the date to be returned as a string
	 * @return formatted string 
	 */
	public static String format(LocalDate date) {
		if (date == null) {
			return null;
		}
		return DATE_FORMATTER.format(date);
	}
	
	/**
	 * Converts a String in the format of the defined {@link DateUtil#DATE_PATTERN}
	 * to a {@link LocalDate} object.
	 * 
	 * Returns null if the String could not be converted.
	 * 
	 * @param dateString the date as String
	 * @return the date object or null if it could not be converted
	 */
	public static LocalDate parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
	
	/**
	 * Checks the String whether it is a valid date.
	 * 
	 * @param dateString
	 * @return true if the string is a valid date
	 */
	public static boolean validDate(String dateString) {
		// Try to parse the String.
		return DateUtil.parse(dateString) != null;
	}
}
