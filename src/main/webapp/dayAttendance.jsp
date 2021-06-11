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
h2 {
	color: black;
	text-align: center;
}

h3 {
	color: blue;
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
		<a href="allAttendanceDisplay.jsp">Previous page</a><br />
		<!-- Display Day Attendance -->
		<figure>
			<figcaption>
				<h2>DIVVLEARN ATTENDANCE PORTAL</h2>
				<br />
			</figcaption>
			<%
			AttendanceService attendanceService = new AttendanceService();
			LocalDate date = LocalDate.parse(request.getParameter("attendanceDate"));
			int count = attendanceService.studentCount(date);
			if (count != 0) {
			%>
			<h3>
				<%
				out.println("TOTAL NUMBER OF STUDENTS : " + count);
				%>
			</h3>
			<%
			}
			Map<String, Integer> attendanceTypeCount = attendanceService.allAttendanceTypeCount(date);
			if (attendanceTypeCount != null && !attendanceTypeCount.isEmpty()) {
			for (String status : attendanceTypeCount.keySet()) {
				Integer value = attendanceTypeCount.get(status);
			%>
			<h4>
				<%
				out.println(status + " : ");
				out.println(value);
				}
				}
				%>
			</h4>
			<br />
			<table border="1" class="table">
				<thead class="thead-dark">

					<tr>
						<th scope="col">STUDENT ROLL NUMBER</th>
						<th scope="col">DATE</th>
						<th scope="col">ATTENDANCE STATUS</th>
					</tr>
				<tbody>
					<%
					List<AttendanceDetails> allAttendanceData = attendanceService.allAttendance(date);
					if (allAttendanceData != null && !allAttendanceData.isEmpty()) {
						int i = 1;
						for (AttendanceDetails attendance : allAttendanceData) {
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