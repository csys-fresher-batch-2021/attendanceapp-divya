/**
 * 
 */
package in.divya.util;

import in.divya.exceptions.InValidLongNumberTypeException;
import in.divya.exceptions.InValidMobileNumberException;
import in.divya.exceptions.InValidNumberLengthException;
import in.divya.exceptions.NumberCannotBeNegativeException;

/**
 * @author divy2624
 *
 */
public class MobileNumberValidatorUtil {
	private MobileNumberValidatorUtil() {
		// Default Constructor
	}

	/**
	 * This Method validates if the mobile number contains only Long integer.
	 * 
	 * @param number
	 * @param errorMessage
	 * @return
	 * @throws ParseException
	 * @throws InValidLongNumberTypeException
	 */

	public static Long isValidNumberOnly(String number, String errorMessage) throws InValidLongNumberTypeException {

		try {
			return Long.parseLong(number);
		} catch (Exception e) {
			throw new InValidLongNumberTypeException(errorMessage);
		}

	}

	/**
	 * This method checks whether the length of mobile number is 10 digits
	 * 
	 * @param number
	 * @return
	 * @throws InValidNumberLengthException
	 */
	public static boolean isNumberValidLength(Long number) throws InValidNumberLengthException {

		if (number != null) {
			long numberString = (long) number.toString().trim().length();
			if ((numberString == 10) && number != 0) {
				return true;
			} else {
				throw new InValidNumberLengthException("Invalid Mobile Number Length");
			}
		}
		return false;
	}

	public static boolean isNumberPositive(Long number) throws NumberCannotBeNegativeException {
		boolean isValidNumber = false;
		if (number != null) {
			if (number > 0) {
				isValidNumber = true;
			} else {
				throw new NumberCannotBeNegativeException("Mobile Number Cannot be Negative");
			}
		}
		return isValidNumber;
	}

	/**
	 * This method checks whether a given mobile number is a 10 digit number and the
	 * number is not negative and the number is not zero.
	 * 
	 * @param mobileNumber
	 * @return
	 * @throws InValidMobileNumberException
	 */
	public static boolean isValidMobileNumber(long mobileNumber) throws InValidMobileNumberException {
		try {
			isNumberValidLength(mobileNumber);
			isNumberPositive(mobileNumber);
			return true;

		} catch (Exception e) {
			throw new InValidMobileNumberException(e.getMessage());
		}

	}

}
