package in.divya.service;

import java.util.List;

import in.divya.dao.StudentDAO;
import in.divya.exceptions.CannotRegisterStudentException;
import in.divya.model.StudentDetails;

public class StudentService {
	public StudentService() {
		/**
		 * Default constructor
		 */
	}

	/**
	 * Registration-Add the student details To check it is successfully
	 * 
	 * @param student
	 * @return
	 * @throws CannotRegisterStudentException
	 */

	public boolean addStudent(StudentDetails student) throws CannotRegisterStudentException {
		StudentDAO studentDetailDAO = new StudentDAO();
		boolean isAddedStudent = true;
		try {
			studentDetailDAO.saveStudent(student);
			return isAddedStudent;
		} catch (Exception e) {
			throw new CannotRegisterStudentException("ALREADY REGISTERED");

		}
	}

	/**
	 * To display Students List
	 * 
	 * @param facultyEmailId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<StudentDetails> studentsList(String facultyEmailId) throws ClassNotFoundException {
		StudentDAO studentDAO = new StudentDAO();
		return studentDAO.findStudentsList(facultyEmailId);

	}

	/**
	 * To display student information.
	 * 
	 * @param studentRollnumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<StudentDetails> studentInformation(String studentRollnumber) throws ClassNotFoundException {
		StudentDAO studentDAO = new StudentDAO();
		return studentDAO.findStudentInformation(studentRollnumber);
	}

}
