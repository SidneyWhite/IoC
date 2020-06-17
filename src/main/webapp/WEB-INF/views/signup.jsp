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
			</div>
		</div>
	</section>
	<section class="container">

		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Register as a user</h3>
					</div>
					<div class="panel-body">

						<form:form modelAttribute="newUser" class="form-horizontal"
							action="signup" method="post">

							<form:errors path="*" cssClass="alert alert-danger" element="div" />
							
							<div class="form-group">
								<label class="control-label col-lg-3" for="userName">
									User Name</label>
								<div class="col-lg-9">
									<form:input id="userName" path="userName" type="text"
										class="form:input-large form-control" required="required"/>
									<form:errors path="userName" cssClass="text-danger" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-3" for="firstName">First
									Name</label>
								<div class="col-lg-9">
									<form:input id="firstName" path="firstName" type="text"
										class="form:input-large form-control" required="required"/>
									<form:errors path="firstName" cssClass="text-danger" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-3" for="lastName">Last
									Name</label>
								<div class="col-lg-9">
									<div class="form:input-prepend">
										<form:input id="lastName" path="lastName" type="text"
											class="form:input-large form-control" required="required"/>
										<form:errors path="lastName" cssClass="text-danger" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-3" for="roleId">Roles</label>
								<div class="col-lg-9">
									<div class="form:input-prepend">
										<form:select id="roleId" path="roleId" class="form-control">
											<form:options items="${roles}" />
										</form:select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-3" for="street">Email</label>
								<div class="col-lg-9">
									<div class="form:input-prepend">
										<form:input id="email" path="email" type="text"
											class="form:input-large form-control" required="required"/>
										<form:errors path="email" cssClass="text-danger" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-lg-3" for="city">Password</label>
								<div class="col-lg-9">
									<div class="form:input-prepend">
										<form:input id="password" path="password" type="password"
											class="form:input-large form-control" required="required"/>
										<form:errors path="password" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-3" for="state">Verify
									Password</label>
								<div class="col-lg-9">
									<div class="form:input-prepend">
										<form:input id="verifyPassword" path="verifyPassword"
											type="password" class="form:input-large form-control" required="required"/>
										<form:errors path="verifyPassword" cssClass="text-danger" />
									</div>
								</div>
							</div>
							<p id="buttons">
								<input id="submit" type="submit" value="Register" class="btn btn-lg btn-primary btn-block">
							</p>
						</form:form>
					</div>
				</div>
			</div>
	</section>

</body>
</html>