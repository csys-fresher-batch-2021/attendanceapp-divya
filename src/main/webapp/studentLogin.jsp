<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Student Login</title>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
}

.head {
	font-weight: bold;
	font-size: 25px;
	text-align: center;
}

label {
	font-weight: bold;
	width: 100px;
	font-size: 15px;
}

.box {
	border: #666666 solid 1px;
}

h1 {
	color: blank;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br />
		<div class="head">
			<h1>DIVVLEARN SECONDARY SCHOOL</h1>
		</div>
		<br>
		<div style="width: 400px; height: 500px; border: solid 1px #333333;">
			<div style="background-color: #333333; color: #FFFFFF; padding: 3px;">
				<h2>STUDENT LOGIN PORTAL</h2>
			</div>
			<div style="margin: 30px">
				<form action="StudentLoginServlet" method="post">
					<label>NAME : </label><br /> <input type="text" name="studentName"
						id="studentName" placeholder="Enter Your Name" required><br />
					<br /> <label>ROLL NUMBER : </label><br /> <input type="text"
						name="studentRollNumber" id="studentRollNumber"
						placeholder="Enter Your Roll Number" required><br /> <br />
					<label>PASSWORD : </label><br /> <input type="password"
						name="studentPassword" id="studentPassword"
						placeholder="Enter Your Password" required><br /> <br />
					<button class="btn btn-primary">SUBMIT</button>
				</form>
				<br />
				<p>
					Don't have an account? <a href="studentRegister.jsp">Sign up
						now</a>.
				</p>
				<div style="font-size: 11px; color: #cc0000; margin-top: 10px"></div>
				<%
				String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					out.println("<font color='blue'>" + errorMessage + "</font>");
				}
				%>
			</div>
		</div>
	</main>
</body>
</html>