package in.divya.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.service.ReasonService;
import in.divya.util.DateValidatorUtil;
import in.divya.validator.RollNumberValidator;

/**
 * Servlet implementation class ReasonRemoveServlet
 */
@WebServlet("/ReasonRemoveServlet")
public class ReasonRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReasonRemoveServlet() {
		super();
	}

	/**
	 * To delete reason.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReasonService reasonService = new ReasonService();
		try {
			String studentRollNumber = request.getParameter("rollNumber");
			String date = request.getParameter("dateOfReason");
			RollNumberValidator.isValidRollNumberFormat(studentRollNumber, "Invalid RollNumber Format");
			LocalDate attendanceDate = DateValidatorUtil.isDateFormatOrNot(date, "Invalid Date Format");
			boolean isRemoveReason = reasonService.deleteReason(studentRollNumber, attendanceDate);
			if (isRemoveReason) {
				String message = "SUCCESSFULLY REMOVED";
				response.sendRedirect("viewReason.jsp?infoMessage=" + message);

			} else {
				throw new InValidCredentialsException("REASON DETAIL NOT FOUND");
			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("viewReason.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}
	}
}
