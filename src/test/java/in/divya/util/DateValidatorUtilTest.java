package in.divya.util;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import in.divya.exceptions.InValidDateException;

public class DateValidatorUtilTest {

	/**
	 * To check Future Date TestCase.
	 */

	@Test
	public void futureDateIsTested() {
		try {
			LocalDate testDate = LocalDate.now().plusDays(1);
			DateValidatorUtil.isNotAFutureDate(testDate, "Invalid Date");
		} catch (Exception e) {
			assertEquals("Invalid Date", e.getMessage());
		}

	}

	/**
	 * To check Present Date TestCase.
	 */

	@Test
	public void presentDateIsTested() throws InValidDateException {
		LocalDate testDate = LocalDate.now();
		boolean isValidEmployeeId = DateValidatorUtil.isNotAFutureDate(testDate, "Invalid Date");
		assertTrue(isValidEmployeeId);
	}

	/**
	 * To check Past Date TestCase.
	 */

	@Test
	public void pastDateIsChecked() throws InValidDateException {
		LocalDate testDate = LocalDate.now().minusDays(1);
		boolean isValidEmployeeId = DateValidatorUtil.isNotAFutureDate(testDate, "Invalid Date");
		assertTrue(isValidEmployeeId);
	}

	/**
	 * To check Valid Date Format TestCase.
	 * 
	 * @throws InValidDateException
	 */

	@Test
	public void validDateFormatOrNotIsChecked() throws InValidDateException {
		String testDate = "2000-12-12";
		LocalDate ValidDate = DateValidatorUtil.isDateFormatOrNot(testDate, "Invalid Date format");
		assertEquals(ValidDate, LocalDate.parse("2000-12-12"));
	}

	/**
	 * To check InValid Date Format TestCase.
	 */

	@Test
	public void inValidDateFormatIsChecked() {
		try {
			String testDate = "2000-12-1";
			DateValidatorUtil.isDateFormatOrNot(testDate, "Invalid Date format");
		} catch (Exception e) {
			assertEquals("Invalid Date format", e.getMessage());
		}

	}

}
