/**
 * 
 */
package in.divya.service;

import java.time.LocalDate;
import java.util.List;

import in.divya.dao.ReasonDAO;
import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.ReportDetails;
import in.divya.model.FacultyDetails;
import in.divya.model.ReasonDetails;

/**
 * @author divy2624
 *
 */
public class ReasonService {
	public ReasonService() {
		/**
		 * Default constructor
		 */
	}

	/**
	 * To add reason for absent or onduty.
	 * 
	 * @param reason
	 * @return
	 * @throws InValidCredentialsException
	 */
	public boolean addReason(ReasonDetails reason) throws InValidCredentialsException {
		ReasonDAO reasonDAO = new ReasonDAO();
		boolean isAddedAttendance = true;
		try {
			reasonDAO.saveReason(reason);
			return isAddedAttendance;
		} catch (Exception e) {
			throw new InValidCredentialsException("ALREADY EXISTS");
		}
	}

	/**
	 * To display all reasons.
	 * 
	 * @param facultyId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<ReasonDetails> displayAllReasons(String facultyId) throws ClassNotFoundException {
		ReasonDAO reasonDAO = new ReasonDAO();
		return reasonDAO.findAllReasons(facultyId);
	}

	/**
	 * To display absent report.
	 * 
	 * @param facultyId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<ReportDetails> displayAbsentReport(String facultyId) throws ClassNotFoundException {
		ReasonDAO reasonDAO = new ReasonDAO();
		return reasonDAO.findALLAbsent(facultyId);
	}

	/**
	 * To display faculty details
	 * 
	 * @param facultyId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<FacultyDetails> displayFacultyDetails(String facultyId) throws ClassNotFoundException {
		ReasonDAO reasonDAO = new ReasonDAO();
		return reasonDAO.findFacultyById(facultyId);
	}

	/**
	 * To display onduty report.
	 * 
	 * @param facultyId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<ReportDetails> displayOnDutyReport(String facultyId) throws ClassNotFoundException {
		ReasonDAO reasonDAO = new ReasonDAO();
		return reasonDAO.findALLOnDuty(facultyId);
	}

	/**
	 * To delete reasons.
	 * 
	 * @param studentRollNumber
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */
	public boolean deleteReason(String studentRollNumber, LocalDate date)
			throws ClassNotFoundException, InValidCredentialsException {
		ReasonDAO reasonDAO = new ReasonDAO();
		boolean isRemoveReason = true;
		try {
			reasonDAO.removeReason(studentRollNumber, date);
			return isRemoveReason;
		} catch (Exception e) {
			throw new InValidCredentialsException("REASON DETAIL NOT FOUND");
		}
	}

}
