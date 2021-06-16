<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
<style>
form {
	text-align: center;
}

label {
	font-weight: bold;
	width: 200px;
	font-size: 16px;
}

h2 {
	color: blank;
	text-align: center;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br />

		<button class="btn btn-link"
			onclick="window.location.href='http://localhost:8080/app/index.jsp'">BACK</button>
		<h2>REGISTRATION FORM</h2>
		<br /> <br />
		<!--  Get the StudentDetails -->
		<form action="StudentRegisterServlet" method="post">
			<label>STUDENT NAME : </label> <input type="text" name="studentName"
				id="studentName" placeholder="Enter Your Name" required autofocus><br />
			<br /> <label>FATHER NAME : </label> <input type="text"
				name="fatherName" id="fatherName"
				placeholder="Enter Your Father Name" required><br /> <br />
			<label>MOTHER NAME : </label> <input type="text" name="motherName"
				id="motherName" placeholder="Enter Your Mother Name" required><br />
			<br /> <label>EMAIL-ID : </label> <input type="email" name="emailId"
				id="emailId" placeholder="Enter Your EmailId" required><br />
			<br /> <label>PASSWORD : </label> <input type="password"
				name="password" id="password" placeholder="Enter Your Password"
				required><br /> <br /> <label>ROLL NUMBER : </label> <input
				type="text" name="rollNumber" id="rollNumber"
				placeholder="Enter Your Roll Number" required><br /> <br />
			<label>GENDER : </label><br /> <label for="male"> <input
				type="radio" id="male" name="gender" value="male" required>
				Male
			</label> <label for="female"> <input type="radio" id="female"
				name="gender" value="female" required> Female
			</label> <label for="other"> <input type="radio" id="other"
				name="gender" value="other" required> Other
			</label><br /> <br /> <label>ADDRESS : </label> <input type="text"
				name="address" id="address" placeholder="Enter Your Address"
				required><br /> <br /> <label>CITY : </label> <input
				type="text" name="city" id="city" placeholder="Enter Your City"
				required><br /> <br /> <label>OCCUPATION(PARENTS)
				: </label> <input type="text" name="occupation" id="occupation"
				placeholder="Enter Your Parents Occupation" required><br />
			<br /> <label>BLOOD GROUP : </label> <input type="text"
				name="bloodGroup" id="bloodGroup"
				placeholder="Enter Your Blood-Group" required><br /> <br />
			<label>STANDARD : </label> <input type="text" name="standard"
				id="standard" placeholder="Enter Your Standard" required><br />
			<br /> <label>FACULTY-IN-CHARGE(EMAIL-ID) : </label> <input type="email"
				name="facultyEmailId" id="facultyEmailId"
				placeholder="Enter StaffEmailId" required><br /> <br /> <label>
				PARENT MOBILE NUMBER:</label> <input type="number" name="mobileNumber"
				id="mobileNumber" placeholder="Enter Mobile Number"><br />
			<br /> <label>DATE OF BIRTH: </label> <input type="date"
				name="dateOfBirth" id="dateOfBirth" min="2004-01-01"
				max="2016-01-01" placeholder="YYYY-MM-DD" required><br /> <br />
			<button class="btn btn-primary">SUBMIT</button>
			<button type="reset" class="btn btn-secondary">RESET</button>
			<br /> <br />
			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='blue'>" + errorMessage + "</font>");
			}
			String infoMessage = request.getParameter("infoMessage");
			if (infoMessage != null) {
				out.println("<font color='blue'>" + infoMessage + "</font>");
			}
			%>
		</form>
	</main>
</body>
</html>