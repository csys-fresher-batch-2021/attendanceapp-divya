/**
 * 
 */
package in.divya.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

/**
 * @author divy2624
 *
 */
public class FacultyLoginTest {

	static FacultyService facultyService = new FacultyService();

	/**
	 * Both are Valid
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isBothValidTestCase() throws ClassNotFoundException, SQLException {
		String facultyName = "M.LAKSHMI";
		String facultyEmailId = "laksram@gmail.com";
		String facultyPassword = "Rlakshmi@123";
		boolean inValidCredentials = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
		assertTrue(inValidCredentials);
	}

	/**
	 * InValid name and Valid emailId,password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isNameInValidTestCase() throws ClassNotFoundException, SQLException {
		String facultyName = "SELVA";
		String facultyEmailId = "laksram@gmail.com";
		String facultyPassword = "Rlakshmi@123";
		boolean inValidCredentials = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Valid name,emailID and InValid password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isPasswordInValidTestCase() throws ClassNotFoundException, SQLException {
		String facultyName = "M.LAKSHMI";
		String facultyEmailId = "laksram@gmail.com";
		String facultyPassword = "RLaks@123";
		boolean inValidCredentials = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Both are InValid
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isBothInvalidTestCase() throws ClassNotFoundException, SQLException {
		String facultyName = "RAMYA";
		String facultyEmailId = "laks@gmail.com";
		String facultyPassword = "Ramya@56";
		boolean inValidCredentials = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
		assertFalse(inValidCredentials);
	}

}
