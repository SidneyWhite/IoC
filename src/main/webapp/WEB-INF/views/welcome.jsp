<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		<security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />
			<div class="pull-left">
				<h3>${SpecialBlurb}</h3>
			</div>
			<spring:url value="/dologout" var="logout_url" />
			<form:form action="${logout_url}" class="form-horizontal"
				method="POST">
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd"
							class="btn btn-danger btn-mini  pull-right" value="Logout" />
					</div>
				</div>
			</form:form>
		</security:authorize>

		<security:authorize access="isAnonymous()">
			<a href="<spring:url value='/login' />"
				class="btn btn-default pull-right"> Login</a>
		</security:authorize>

		<security:authorize access="hasRole('ROLE_CHECKER')">
		    IS IN CHECKER
		</security:authorize>
		<security:authorize access="hasRole('ROLE_STUDENT')">
		    IS IN STUDENT
		</security:authorize>
	</p>

</body>
</html>