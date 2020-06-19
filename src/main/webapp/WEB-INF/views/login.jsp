<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>TM Checking</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>TM Checking System</h1>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Login</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message
									code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
								<br />
							</div>
						</c:if>
						<form action="<spring:url value="/login"></spring:url>"
							method="post">
							<fieldset>
								<div class="form-group">
									<input class="form:input-large form-control" placeholder="User Name"
										name='username' type="text" required="required">
								</div>
								<div class="form-group">
									<input class=" form:input-large form-control" placeholder="Password"
										name='password' type="password" value="" required="required">
								</div>
								<div class="form-group">
									<input type='checkbox' name="keepMe" /> Remember Me <br />
								</div>
								<input class="btn btn-lg btn-primary btn-mini" type="submit"
									value="Login">
								
								<a href="<c:url value="/signup" />" class="btn btn-warning btn-lg pull-right">Sign Up</a>	
							</fieldset>
							<security:csrfInput />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>