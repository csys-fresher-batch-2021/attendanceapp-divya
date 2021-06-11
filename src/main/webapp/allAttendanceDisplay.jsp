<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.AttendanceService"%>
<%@page import="in.divya.model.AttendanceDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ALL Student Attendance</title>
<style>
form {
	text-align: center;
}

h2 {
	color: black;
	text-align: center;
}
h4 {
	color: brown;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="facultyHomePage.jsp">Previous page</a><br />
		<!-- Display All Attendance -->
		<figure>
			<figcaption>
				<h2>DIVVLEARN ATTENDANCE PORTAL</h2>
				<br />
			</figcaption>
			<form action="AttendanceDisplayServlet" method="post">
				<label for="date">DATE : </label> <input type="date"
					name="dateOfAttendance" id="dateOfAttendance" min="2021-01-01"
					max="2021-12-31" value="<%=LocalDate.now()%>" required>
				<button class="button">SEARCH</button>
				<br />
				<%
				String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					out.println("<font color='brown'>" + errorMessage + "</font>");
				}
				%>
			</form>
			<br />
			<table border="1" class="table">
				<thead class="thead-dark">

					<tr>
					    <th scope="col">STUDENT ROLL NUMBER</th>
						<th scope="col">DATE</th>
						<th scope="col">ATTENDANCE</th>
					</tr>
				<tbody>
					<%
					AttendanceService attendanceService = new AttendanceService();
					List<AttendanceDetails> attendanceData = attendanceService.displayAllAttendance();
					if (attendanceData != null && !attendanceData.isEmpty()) {
						int i = 1;
						for (AttendanceDetails attendance : attendanceData) {
							i++;
					%>
					<tr>
						<td><%=attendance.getStudentRollNumber()%></td>
						<td><%=attendance.getDate()%></td>
						<td><%=attendance.getAttendance()%></td>

					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="3"><h4>ATTENDANCE NOT FOUND</h4></td>
					</tr>
					<%
					}
					%>
				</tbody>
				<thead>
			</table>
		</figure>
	</main>
</body>
</html>