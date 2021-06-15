<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.ReasonService"%>
<%@page import="in.divya.model.ReasonDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>REASON DISPLAY</title>
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
		<!-- Display onduty or absent reasons-->
		<figure>
			<figcaption>
				<h2>REASONS FOR ABSENT AND ONDUTY</h2>
				<br />
			</figcaption>
			<form action="ReasonRemoveServlet" method="post">
				<label>STUDENT ROLL NUMBER : </label> <input type="text"
					name="rollNumber" id="rollNumber"
					placeholder="ENTER STUDENT ROLL NUMBER" required> <label
					for="date">DATE : </label> <input type="date" name="dateOfReason"
					id="dateOfReason" min="2021-01-01" max="2021-12-31"
					value="<%=LocalDate.now()%>" required>
				<button class="button">REMOVE</button>
				<br />
				<%
				String infoMessage = request.getParameter("infoMessage");
				if (infoMessage != null) {
					out.println("<font color='brown'>" + infoMessage + "</font>");
				}
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
						<th scope="col">ATTENDANCE TYPE</th>
						<th scope="col">REASON</th>
					</tr>
				<tbody>
					<%
					String facultyEmailId = (String) session.getAttribute("LOGGED_IN_USER_ID");
					ReasonService reasonService = new ReasonService();
					List<ReasonDetails> reasonData = reasonService.displayAllReasons(facultyEmailId);
					if (reasonData != null && !reasonData.isEmpty()) {
						int i = 1;
						for (ReasonDetails reason : reasonData) {
							i++;
					%>
					<tr>
						<td><%=reason.getStudentRollNumber()%></td>
						<td><%=reason.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))%></td>
						<td><%=reason.getAttendanceType()%></td>
						<td><%=reason.getReason()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="4"><h4>REASONS NOT FOUND</h4></td>
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