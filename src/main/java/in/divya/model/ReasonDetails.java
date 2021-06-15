/**
 * 
 */
package in.divya.model;

import java.time.LocalDate;

/**
 * @author divy2624
 *
 */
public class ReasonDetails {
	/**
	 * To declare the abseny,onduty reasons.
	 */

	private String studentRollNumber;
	private LocalDate date;
	private String attendanceType;
	private String facultyEmailId;
	private String reason;

	/**
	 * @return the studentRollNumber
	 */
	public String getStudentRollNumber() {
		return studentRollNumber;
	}

	/**
	 * @param studentRollNumber the studentRollNumber to set
	 */
	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the attendanceType
	 */
	public String getAttendanceType() {
		return attendanceType;
	}

	/**
	 * @param attendanceType the attendanceType to set
	 */
	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	/**
	 * @return the facultyEmailId
	 */
	public String getFacultyEmailId() {
		return facultyEmailId;
	}

	/**
	 * @param facultyEmailId the facultyEmailId to set
	 */
	public void setFacultyEmailId(String facultyEmailId) {
		this.facultyEmailId = facultyEmailId;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ReasonDetails [studentRollNumber=" + studentRollNumber + ", date=" + date + ", attendanceType="
				+ attendanceType + ", facultyEmailId=" + facultyEmailId + ", reason=" + reason + "]";
	}
}
