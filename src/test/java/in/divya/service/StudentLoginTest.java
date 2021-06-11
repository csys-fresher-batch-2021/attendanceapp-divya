package in.divya.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentLoginTest {

	static StudentService studentService = new StudentService();

	/**
	 * All are Valid
	 * 
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isStudentBothValidTestCase() throws ClassNotFoundException {
		String studentName = "K.DIVYA";
		String studentRollNumber = "AA22BB1111";
		String studentPassword = "Divya@76";
		boolean inValidCredentials = studentService.studentValidation(studentName, studentRollNumber, studentPassword);
		assertTrue(inValidCredentials);
	}

	/**
	 * InValid Rollnumber and password
	 * 
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isRollNumberInValidTestCase() throws ClassNotFoundException {
		String studentName = "K.DIVYA";
		String studentRollNumber = "AA2B1111";
		String studentPassword = "divya@76";
		boolean inValidCredentials = studentService.studentValidation(studentName, studentRollNumber, studentPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * InValid Name and Invalid password
	 * 
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isPasswordInValidTestCase() throws ClassNotFoundException {
		String studentName = "K.DIVYA";
		String studentRollNumber = "AA22BB1111";
		String studentPassword = "Divya";
		boolean inValidCredentials = studentService.studentValidation(studentName, studentRollNumber, studentPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Invalid Name and Password
	 * 
	 * @throws ClassNotFoundException
	 */
	@Test
	public void isNameInValidTestCase() throws ClassNotFoundException {
		String studentName = "M.KAVITHA";
		String studentRollNumber = "AA22BB1111";
		String studentPassword = "Divya@76";
		boolean inValidCredentials = studentService.studentValidation(studentName, studentRollNumber, studentPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * All are Invalid
	 * 
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isBothStudentInValidTestCase() throws ClassNotFoundException {
		String studentName = "M.RAM";
		String studentRollNumber = "AA28NN0911";
		String studentPassword = "Ramyuu76";
		boolean inValidCredentials = studentService.studentValidation(studentName, studentRollNumber, studentPassword);
		assertFalse(inValidCredentials);
	}

}
