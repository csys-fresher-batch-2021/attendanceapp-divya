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
import in.divya.model.ReportDetails;
import in.divya.model.FacultyDetails;
import in.divya.model.ReasonDetails;
import in.divya.model.StudentDetails;
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
			String sql = "insert into reason(student_roll_number,attendance_date,attendance_type,faculty_email_id,reason)values(?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, reason.getStudentRollNumber());
			pst.setObject(2, reason.getDate());
			pst.setString(3, reason.getAttendanceType());
			pst.setString(4, reason.getFacultyEmailId());
			pst.setString(5, reason.getReason());
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
	 * @param facultyId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<ReasonDetails> findAllReasons(String facultyId) throws ClassNotFoundException {
		List<ReasonDetails> allReasonsData = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "select * from reason where faculty_email_id=? order by attendance_date desc";
			pst = connection.prepareStatement(sql);
			pst.setString(1, facultyId);
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

	/**
	 * To display absent details.
	 * 
	 * @param facultyId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<ReportDetails> findALLAbsent(String facultyId) throws ClassNotFoundException {
		List<ReportDetails> absentReportDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select reason.student_roll_number,student.student_name,reason.attendance_date,reason.attendance_type,reason.reason,student.parent_mobile_number from reason inner join student on reason.student_roll_number=student.student_roll_number and reason.faculty_email_id=? and reason.attendance_type='ABSENT' order by reason.attendance_date";
			pst = connection.prepareStatement(sql);
			pst.setString(1, facultyId);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentDetails student = new StudentDetails();
				ReasonDetails reason = new ReasonDetails();
				ReportDetails absentDetails = new ReportDetails();
				reason.setStudentRollNumber(rs.getString("student_roll_number"));
				student.setStudentName(rs.getString("student_name"));
				reason.setDate(LocalDate.parse(rs.getString("attendance_date")));
				reason.setAttendanceType(rs.getString("attendance_type"));
				reason.setReason(rs.getString("reason"));
				student.setParentMobileNumber(Long.parseLong(rs.getString("parent_mobile_number")));
				absentDetails.setStudent(student);
				absentDetails.setReason(reason);
				absentReportDetails.add(absentDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return absentReportDetails;
	}

	/**
	 * To display faculty details.
	 * 
	 * @param facultyId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<FacultyDetails> findFacultyById(String facultyId) throws ClassNotFoundException {
		List<FacultyDetails> facultyData = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select faculty_name,faculty_class,faculty_email_id,faculty_mobile_number from faculty_data where faculty_email_id=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, facultyId);
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

	/**
	 * To display onduty details
	 * 
	 * @param facultyId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<ReportDetails> findALLOnDuty(String facultyId) throws ClassNotFoundException {
		List<ReportDetails> absentReportDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select reason.student_roll_number,student.student_name,reason.attendance_date,reason.attendance_type,reason.reason,student.parent_mobile_number from reason inner join student on reason.student_roll_number=student.student_roll_number and reason.faculty_email_id=? and reason.attendance_type='ONDUTY' order by reason.attendance_date";
			pst = connection.prepareStatement(sql);
			pst.setString(1, facultyId);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentDetails student = new StudentDetails();
				ReasonDetails reason = new ReasonDetails();
				ReportDetails absentDetails = new ReportDetails();
				reason.setStudentRollNumber(rs.getString("student_roll_number"));
				student.setStudentName(rs.getString("student_name"));
				reason.setDate(LocalDate.parse(rs.getString("attendance_date")));
				reason.setAttendanceType(rs.getString("attendance_type"));
				reason.setReason(rs.getString("reason"));
				student.setParentMobileNumber(Long.parseLong(rs.getString("parent_mobile_number")));
				absentDetails.setStudent(student);
				absentDetails.setReason(reason);
				absentReportDetails.add(absentDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return absentReportDetails;
		
	}
}
