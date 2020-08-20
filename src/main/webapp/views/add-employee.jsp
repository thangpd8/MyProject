<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Employee</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script 	src="<%=request.getContextPath()%>/resources/js/jquery.js"> </script>
</head>
<body>
	<%-- <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><i class="fa fa-home"></i>Home
			Page</a>
		<div id="navbarNavDropdown" class="navbar-collapse collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#"
					id="addEmplink">Add an Employee</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					id="listEmplink">List Employee</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" style="color: yellow"
					href="#"><i class="fa fa-user-circle-o"></i>${userLogin.userName}</a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i
						class="fa fa-user-times"></i>Logout</a></li>
			</ul>
		</div>
	</nav> --%>

	<br />

	<form action="<%=request.getContextPath()%>/add-employee" method="post" name="frm-addEmp">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2>Add an Employee</h2>
				<p style="color: blue">${message}</p>
				<div class="form-group">
					<label for="employeeName">Name:</label> <input type="text"
						class="form-control" id="employeeName" placeholder="Enter name"
						name="employeeName" value="${employee.employeeName}">

				</div>

				<label for="gender">Gender:</label>
				<div class="form-check-inline">
					<label class="form-check-label"> <input type="radio"
						class="form-check-input" name="gender" value="1" checked>Male
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label"> <input type="radio"
						class="form-check-input" name="gender" value="0"
						${employee.gender == 0 ? 'checked' : ''}>Female
					</label>
				</div>

				<div class="form-group">
					<label for="dateOfBirth">Date of birth:</label> <input type="date"
						class="form-control" id="dateOfBirth"
						placeholder="Enter date of birth" name="dateOfBirth"
						value=" <ftm:formartDate value='${employee.dateOfBirth}' pattern='yyyy-MM-dd'/>">
				</div>

				<div class="form-group">
					<label for="dept">Department:</label> <select class="form-control"
						id="dept">
						<c:forEach items="${listOfDepartment}" var="department">
							<option value="${department.departmentId}"
								${department.departmentId == employee.departmentId ? 'selected' : ''}>
								${department.departmentName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6 offset-md-3">
				<button type="button" id="btn-addEmp" class="btn btn-primary">Add
					Employee</button>
			</div>
		</div>
	</form>
	<div class="row fixed-bottom"
		style="border-top: 1px solid #ccc; background-color: #222">
		<div class="col-md-12">
			<p style="margin: 10px auto; text-align: center; color: #ccc">&copy;
				Copyright Fresher Academy</p>
		</div>
	</div>

	<script>
		$(document).ready(function() {	
			$("#btn-addEmp").click(function() {
				var employeeName = $("#employeeName").val();
				var gender = $("input[name=gender]:checked").val();
				var dateOfBirth = $("#dateOfBirth").val();
				var depId = $("#dept").val();
				$.post({
					url : "${pageContext.request.contextPath}/add-employee",
					data : {
						employeeName : employeeName,
						gender : gender,
						dateOfBirth : dateOfBirth,
						deptId : depId
					},
					success : function(response) {
						$(".container").html(response);
					}
				});
			});
		});
	</script>
</body>
</html>
​
