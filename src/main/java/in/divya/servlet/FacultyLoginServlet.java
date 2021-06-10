package in.divya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.service.FacultyService;
import in.divya.util.EmailValidatorUtil;
import in.divya.util.PasswordValidatorUtil;
import in.divya.util.StringValidatorUtil;

/**
 * Servlet implementation class FacultyLoginServlet
 */
@WebServlet("/FacultyLoginServlet")
public class FacultyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacultyLoginServlet() {
		super();
	}

	/**
	 * Login process
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FacultyService facultyService = new FacultyService();
		try {
			String facultyName = request.getParameter("facultyName");
			String facultyEmailId = request.getParameter("facultyEmailId");
			String facultyPassword = request.getParameter("facultyPassword");
			StringValidatorUtil.isStringNotNullOrEmpty(facultyName, "Cannot accept empty string and null value");
			EmailValidatorUtil.isValidEmailId(facultyEmailId, "InValid EmailId Format");
			PasswordValidatorUtil.isValidPasswordFormat(facultyPassword, "InValid Password Format");
			boolean isValidStudent = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
			if (isValidStudent) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", facultyName);
				session.setAttribute("LOGGED_IN_USER_ID", facultyEmailId);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else {
				throw new InValidCredentialsException("InValid Faculty Credentials");
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("facultyLogin.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}
	}

}
