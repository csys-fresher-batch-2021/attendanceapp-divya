package in.divya.util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.divya.exceptions.InValidBloodGroupFormatException;

/**
 * @author divy2624
 *
 */
public class BloodGroupValidatorUtilTest {

	/**
	 * To check Valid BloodGroup Format TestCase
	 * 
	 * @throws InValidBloodGroupFormatException
	 */

	@Test
	public void validBloodGroupFormatIsTeste() throws InValidBloodGroupFormatException {
		String bloodGroup = "A-";
		boolean isValidBloodGroup = BloodGroupValidatorUtil.isValidBloodGroupFormat(bloodGroup,
				"Invalid bloodGroup format");
		assertTrue(isValidBloodGroup);
	}

	/**
	 * To check InValid BloodGroup Format TestCase
	 */

	@Test
	public void inValidBloodGroupFormatIsTested() {
		try {
			String bloodGroup = "-A";
			boolean isValidBloodGroup = BloodGroupValidatorUtil.isValidBloodGroupFormat(bloodGroup,
					"InValid BloodGroup format");
			assertFalse(isValidBloodGroup);
		} catch (Exception e) {
			assertEquals("InValid BloodGroup format", e.getMessage());
		}
	}


}
