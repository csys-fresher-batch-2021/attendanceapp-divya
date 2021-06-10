package in.divya.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import in.divya.exceptions.InValidRollNumberException;

public class RollNumberValidatorTest {

	/**
	 * To check Roll Number TestCase.
	 * 
	 * @throws InValidRollNumberFormatException
	 */

	@Test
	public void validRollNumberFormatIsTested() throws InValidRollNumberException {
		String rollNumber = "AA23BB3456";
		boolean isValidRollNumber = RollNumberValidator.isValidRollNumberFormat(rollNumber,
				"InValid rollNumber format");
		assertTrue(isValidRollNumber);
	}

	/**
	 * To check Invalid Roll Number TestCase.
	 */

	@Test
	public void inValidRollNumberFormatIsTested1() {
		try {
			String rollNumber = "2345VV67AA";
			boolean isValidPassword = RollNumberValidator.isValidRollNumberFormat(rollNumber,
					"InValid RollNumber format");
			assertFalse(isValidPassword);
		} catch (Exception e) {
			assertEquals("InValid RollNumber format", e.getMessage());
		}
	}

}
