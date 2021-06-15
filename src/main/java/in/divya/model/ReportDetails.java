/**
 * 
 */
package in.divya.model;

/**
 * @author divy2624
 *
 */
public class ReportDetails {
	private StudentDetails student;
	private ReasonDetails reason;

	/**
	 * @return the student
	 */
	public StudentDetails getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(StudentDetails student) {
		this.student = student;
	}

	/**
	 * @return the reason
	 */
	public ReasonDetails getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(ReasonDetails reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "AbsentDTO [student=" + student + ", reason=" + reason + "]";
	}

}
