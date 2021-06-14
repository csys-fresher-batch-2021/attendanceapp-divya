/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.divya.model.FacultyDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class FacultyDAO {
	public FacultyDAO() {
		// Default Constructor
	}

	/**
	 * To validate faculty login.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<String> findFacultyData() throws ClassNotFoundException {

		List<String> facultyCredetials = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select faculty_name,faculty_email_id,faculty_password from faculty_data";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String facultyName = rs.getString("faculty_name");
				String facultyEmailId = rs.getString("faculty_email_id");
				String facultyPassword = rs.getString("faculty_password");
				facultyCredetials.add(facultyName);
				facultyCredetials.add(facultyEmailId);
				facultyCredetials.add(facultyPassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return facultyCredetials;
	}

	/**
	 * To display faculty details.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<FacultyDetails> findFacultyById(String studentRollNumber) throws ClassNotFoundException {
		List<FacultyDetails> facultyData = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select faculty_name,faculty_class,faculty_email_id,faculty_mobile_number from faculty_data where faculty_email_id in (select faculty_email_id from student where student_roll_number=?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, studentRollNumber);
			rs = pst.executeQuery();

			while (rs.next()) {
				FacultyDetails faculty = new FacultyDetails();

				String facultyName = rs.getString("faculty_name");
				String facultyClass = rs.getString("faculty_class");
				String facultyEmailId = rs.getString("faculty_email_id");
				Long facultymobileNumber = Long.parseLong(rs.getString("faculty_mobile_number"));

				faculty.setFacultyName(facultyName);
				faculty.setFacultyClass(facultyClass);
				faculty.setFacultyEmailId(facultyEmailId);
				faculty.setFacultyMobileNumber(facultymobileNumber);
				facultyData.add(faculty);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return facultyData;
	}
}
