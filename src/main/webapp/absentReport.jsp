<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.ReasonService"%>
<%@page import="in.divya.model.AbsentDetails"%>
<%@page import="in.divya.model.FacultyDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ABSENT REPORT</title>
<%
String facultyId = (String) session.getAttribute("LOGGED_IN_USER_ID");
if (facultyId == null) {
	response.sendRedirect("facultyLogin.jsp");
}
%>

<style>
table {
	background-color: #AAB7B8;
	font-weight: bold;
	border: none;
}

p {
	background-color: pink;
	font-weight: bolder;
	padding: 5px;
	text-align: center;
	font-size: 15px;
}

h2 {
	color: black;
	text-align: center;
}

h3 {
	color: black;
	text-align: center;
}
</style>
</head>
<body style="background-color: pink;">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="facultyHomePage.jsp">Previous page</a><br />
		<!-- Display Absent Report -->
		<figure>
			<figcaption>
				<h2>DIVVLEARN SECONDARY SCHOOL</h2>
				<button onclick="window.print()">DOWNLOAD</button>
			</figcaption>
			<table border="1" class="table">
				<thead class="thead-dark">
					<tr>
						<td colspan="6"><h3>DIVVLEARN ABSENT REPORT</h3></td>
					</tr>
					<tr>
						<th scope="col">FACULTY NAME</th>
						<th scope="col">FACULTY CLASS</th>
						<th scope="col">FACULTY EMAIL-ID</th>
						<th scope="col">FACULTY MOBILE NUMBER</th>
					</tr>
				</thead>
				<tbody>
					<%
					ReasonService reasonService = new ReasonService();
					List<FacultyDetails> facultyData = reasonService.displayFacultyDetails(facultyId);
					for (FacultyDetails faculty : facultyData) {
					%>
					<tr>
						<td><%=faculty.getFacultyName()%></td>
						<td><%=faculty.getFacultyClass()%></td>
						<td><%=faculty.getFacultyEmailId()%></td>
						<td><%=faculty.getFacultyMobileNumber()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<table border="1" class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">STUDENT ROLL NUMBER</th>
						<th scope="col">STUDENT NAME</th>
						<th scope="col">ATTENDANCE DATE</th>
						<th scope="col">ATTENDANCE TYPE</th>
						<th scope="col">REASON</th>
						<th scope="col">PARENT MOBILE NUMBER</th>
					</tr>
				<tbody>
					<%
					List<AbsentDetails> absentData = reasonService.displayAbsentReport(facultyId);
					if (absentData != null && !absentData.isEmpty()) {
						int i = 1;
						for (AbsentDetails absent : absentData) {
							i++;
					%>
					<tr>
						<td><%=absent.getReason().getStudentRollNumber()%></td>
						<td><%=absent.getStudent().getStudentName()%></td>
						<td><%=absent.getReason().getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))%></td>
						<td><%=absent.getReason().getAttendanceType()%></td>
						<td><%=absent.getReason().getReason()%></td>
						<td><%=absent.getStudent().getParentMobileNumber()%></td>

					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="6"><h4>REASONS NOT FOUND</h4></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</figure>
	</main>
</body>
</html>

