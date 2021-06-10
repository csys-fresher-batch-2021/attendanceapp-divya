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
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<String> findFacultyData() throws SQLException, ClassNotFoundException {

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

}
