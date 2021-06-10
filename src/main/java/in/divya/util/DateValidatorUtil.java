/**
 * 
 */
package in.divya.util;

import java.time.LocalDate;

import in.divya.exceptions.InValidDateException;

/**
 * @author divy2624
 *
 */
public class DateValidatorUtil {
	private DateValidatorUtil() {
		// Default Constructor
	}

	/**
	 * This method checks whether the date is not a future date or not.
	 * 
	 * @param date
	 * @return
	 * @throws InValidDateException
	 */

	public static boolean isNotAFutureDate(LocalDate date, String errorMessage) throws InValidDateException {
		if (date.isAfter(LocalDate.now())) {
			throw new InValidDateException(errorMessage);
		}
		return true;
	}

	/**
	 * This method checks whether a date is in date format or not and returns the
	 * date if in date format.
	 * 
	 * @param dateToCheck
	 * @param errorMessage
	 * @return
	 * @throws InValidDateException
	 */

	public static LocalDate isDateFormatOrNot(String dateToCheck, String errorMessage) throws InValidDateException {
		try {
			return LocalDate.parse(dateToCheck);
		} catch (Exception e) {
			throw new InValidDateException(errorMessage);
		}
	}


}
