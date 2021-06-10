/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.divya.exceptions.CannotRegisterStudentException;
import in.divya.model.StudentDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class StudentDAO {
	public StudentDAO() {
		// Default Constructor
	}

	/**
	 * This Method Registers a new student into a database with their data.
	 * 
	 * @param student
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws CannotRegisterStudentException
	 */

	public void saveStudent(StudentDetails student)
			throws SQLException, ClassNotFoundException, CannotRegisterStudentException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into student(student_name,father_name,mother_name,student_email_id,student_password,student_roll_number,gender,address,city,parent_occupation,student_blood_group,student_standard,faculty_email_id,parent_mobile_number,date_of_birth) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setString(1, student.getStudentName());
			pst.setString(2, student.getFatherName());
			pst.setString(3, student.getMotherName());
			pst.setString(4, student.getStudentEmailId());
			pst.setString(5, student.getStudentPassword());
			pst.setString(6, student.getStudentRollNumber());
			pst.setString(7, student.getGender());
			pst.setString(8, student.getStudentAddress());
			pst.setString(9, student.getStudentCity());
			pst.setString(10, student.getOccupation());
			pst.setString(11, student.getStudentBloodGroup());
			pst.setString(12, student.getStudentStandard());
			pst.setString(13, student.getFacultyEmailId());
			pst.setLong(14, student.getParentMobileNumber());
			pst.setObject(15, student.getDateOfBirth());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CannotRegisterStudentException("ALREADY REGISTERED");
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

}
