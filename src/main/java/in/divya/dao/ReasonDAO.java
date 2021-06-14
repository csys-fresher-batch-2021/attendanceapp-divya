/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.ReasonDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class ReasonDAO {
	public ReasonDAO() {
		/**
		 * Default constructor
		 */
	}

	/**
	 * To save reasons.
	 * 
	 * @param reason
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */
	public void saveReason(ReasonDetails reason) throws ClassNotFoundException, InValidCredentialsException {
		PreparedStatement pst = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into reason(student_roll_number,attendance_date,attendance_type,reason)values(?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, reason.getStudentRollNumber());
			pst.setObject(2, reason.getDate());
			pst.setString(3, reason.getAttendanceType());
			pst.setString(4, reason.getReason());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InValidCredentialsException("ALREADY EXISTS");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

}
