<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Signup</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Sign Up</h1>
				<p>Register as a user
				<p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newUser" class="form-horizontal"
			action="signup" method="post">
			<fieldset>
				<legend>Register as a user</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="userName">
						User Name</label>
					<div class="col-lg-10">
						<form:input id="userName" path="userName" type="text"
							class="form:input-large" />
						<form:errors path="userName" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="firstName">First
						Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text"
							class="form:input-large" />
						<form:errors path="firstName" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last
						Name</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="lastName" path="lastName" type="text"
								class="form:input-large" />
							<form:errors path="lastName" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="roleId">Roles</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:select id="roleId" path="roleId" class="form-control">
								<form:options items="${roles}"/>
							</form:select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="street">Email</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="email" path="email" type="text"
								class="form:input-large" />
							<form:errors path="email" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="city">Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="password" path="password" type="text"
								class="form:input-large" />
							<form:errors path="password" cssClass="text-danger" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="state">Verify
						Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="verifyPassword" path="verifyPassword" type="text"
								class="form:input-large" />
							<form:errors path="verifyPassword" cssClass="text-danger" />
						</div>
					</div>
				</div>
				<p id="buttons">
					<input id="submit" type="submit" value="Add a User">
				</p>
			</fieldset>
		</form:form>
	</section>

</body>
</html>