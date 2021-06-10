/**
 * 
 */
package in.divya.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.divya.exceptions.InValidBloodGroupFormatException;

/**
 * @author divy2624
 *
 */
public class BloodGroupValidatorUtil {
	private BloodGroupValidatorUtil() {
		// Default Constructor
	}

	/**
	 * This method checks whether the blood group is correct format or not.
	 * 
	 * @param studentBloodGroup
	 * @param errorMessage
	 * @return
	 * @throws InValidBloodGroupFormatException
	 */

	public static boolean isValidBloodGroupFormat(String studentBloodGroup, String errorMessage)
			throws InValidBloodGroupFormatException {
		boolean isValidFormat = false;
		if (studentBloodGroup != null) {
			String regex = "^(A|B|AB|O)[+-]$";
			Pattern regexPattern = Pattern.compile(regex);
			Matcher matchCheck = regexPattern.matcher(studentBloodGroup);
			isValidFormat = matchCheck.matches();
			if (isValidFormat) {
				return isValidFormat;
			}
			throw new InValidBloodGroupFormatException(errorMessage);
		}
		return isValidFormat;

	}


}
