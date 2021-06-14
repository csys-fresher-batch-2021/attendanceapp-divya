/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * To display all reasons.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<ReasonDetails> findAllReasons() throws ClassNotFoundException {
		List<ReasonDetails> allReasonsData = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "select * from reason order by attendance_date desc";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ReasonDetails reason = new ReasonDetails();
				String studentRollNumber = rs.getString("student_roll_number");
				LocalDate attendanceDate = LocalDate.parse(rs.getString("attendance_date"));
				String attendanceType = rs.getString("attendance_type");
				String typeReason = rs.getString("reason");
				reason.setStudentRollNumber(studentRollNumber);
				reason.setDate(attendanceDate);
				reason.setAttendanceType(attendanceType);
				reason.setReason(typeReason);
				allReasonsData.add(reason);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return allReasonsData;
	}
}
