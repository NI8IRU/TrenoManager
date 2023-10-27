<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		<h1>Registration form</h1>
		<form action="insertUtente" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							class="form-control" id="username" name="username"
							placeholder="Enter Username">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="designation">Password</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Enter password">
					</div>
				</div>
			</div>

			<!-- <div class="row">
				<div class="col">
					<div class="form-group">
						<label for="department">Department</label> <input
							type="text" class="form-control" id="department"
							name="department" placeholder="Enter department">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="salary">Salary</label> <input type="number"
							class="form-control" id="salary" name="salary"
							placeholder="Enter Salary">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="address">Address</label>
						<textarea class="form-control" id="address" name="address"
							rows="5" placeholder="Enter Address"> </textarea>
					</div>
				</div>
			</div> -->

			<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Back </a>
			<button type="submit" class="btn btn-primary">Sign in</button>
		</form>

	</div>

</body>
</html>