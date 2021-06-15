package in.divya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.divya.model.FacultyDetails;
import in.divya.service.FacultyService;

/**
 * Servlet implementation class FacultyContactServlet
 */
@WebServlet("/FacultyContactServlet")
public class FacultyContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacultyContactServlet() {
		super();
	}

	/**
	 * This method gets the faculty data from the service class to get display in
	 * the screen.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FacultyService facultyService = new FacultyService();
		String studentRollNumber = request.getParameter("studentRollNumber");
		try {
			List<FacultyDetails> facultyDetails = facultyService.displayFacultyDetails(studentRollNumber);
			Gson gson = new Gson();
			String object = gson.toJson(facultyDetails);
			PrintWriter out = response.getWriter();
			out.println(object);
			out.flush();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
