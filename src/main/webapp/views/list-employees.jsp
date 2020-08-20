<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Employees</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<%=request.getContextPath()%>/resources/js/jquery.js">
	
</script>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark"> <a
		class="navbar-brand" href="#"><i class="fa fa-home"></i>Home Page</a>
	<div id="navbarNavDropdown" class="navbar-collapse collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="#"
				id="addEmpLink">Add an Employee</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				id="listEmpslink">List Employee</a></li>
		</ul>

		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" style="color: yellow"
				href="#"><i class="fa fa-user-circle-o"></i>${userLogin.userName}</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/logout"><i
					class="fa fa-user-times"></i>Logout</a></li>
		</ul>
	</div>
	</nav>

	<div class="container" style="margin-bottom: 100px">

		<br />
		<h2>List Employees</h2>
		<br />
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Employee Name</th>
					<th>Gender</th>
					<th>Date of birth</th>
					<th>Department Name</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${listOfEmployee}" var="employee">
					<tr>
						<td>${employee.employeeId}</td>
						<td>${employee.employeeName}</td>
						<td>${employee.gender == 1 ? 'Male':'Female'}</td>
						<td>${employee.dateOfBirth}</td>
						<td>${employee.department.departmentName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="row fixed-bottom"
		style="border-top: 1px solid #ccc; background-color: #222">
		<div class="col-md-12">
			<p style="margin: 10px auto; text-align: center; color: #ccc">&copy;
				Copyright Fresher Academy 2018</p>
		</div>
	</div>
</body>
</html>