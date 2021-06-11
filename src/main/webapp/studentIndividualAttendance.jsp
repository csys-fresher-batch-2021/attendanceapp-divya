<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.AttendanceService"%>
<%@page import="in.divya.model.AttendanceDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Individual Attendance</title>
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
		<a href="listOfStudents.jsp">Previous page</a><br />
		<!-- Display Individual Student Attendance -->
		<figure>
			<figcaption>
				<h2>DIVVLEARN ATTENDANCE PORTAL</h2>
				<br />
			</figcaption>
			<%
			AttendanceService attendanceService = new AttendanceService();
			String studentRollNumber = request.getParameter("allInfo");
			int count = attendanceService.attendanceCount(studentRollNumber);
			if (count != 0) {
			%>
			<h3>
				<%
				out.println("NUMBER OF DAYS : " + count);
				%>
			</h3>
			<%
			}
			Map<String, Integer> attendanceCount = attendanceService.attendanceTypeCount(studentRollNumber);
			if (attendanceCount != null && !attendanceCount.isEmpty()) {
			for (String status : attendanceCount.keySet()) {
				Integer value = attendanceCount.get(status);
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
						<th scope="col">DATE</th>
						<th scope="col">ATTENDANCE</th>
					</tr>
				<tbody>
					<%
					List<AttendanceDetails> studentAttendanceData = attendanceService.studentAttendance(studentRollNumber);
					if (studentAttendanceData != null && !studentAttendanceData.isEmpty()) {
						int i = 1;
						for (AttendanceDetails attendance : studentAttendanceData) {
							i++;
					%>
					<tr>
						<td><%=attendance.getDate()%></td>
						<td><%=attendance.getAttendance()%></td>

					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="2"><h4>ATTENDANCE NOT FOUND</h4></td>
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