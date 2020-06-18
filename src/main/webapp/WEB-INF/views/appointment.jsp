<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body style="margin-left: 10px">
	<security:authorize access="isAuthenticated()">
         Welcome  
         ${currentUserId } - <security:authentication
			property="principal.username" />

		<spring:url value="/dologout" var="logout_url" />
		<form:form action="${logout_url}" class="form-horizontal"
			method="POST">
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="logout"
						class="btn btn-danger btn-mini  pull-right" value="Logout" />
				</div>
			</div>
		</form:form>
	</security:authorize>
	<h1>Appointment list</h1>
	<div>
		<security:authorize access="hasRole('ROLE_CHECKER')">
			<a
				href="
            <c:url value="/appointments/add" />
            "
				class="btn btn-primary" type="button">Add new appointment</a>
		</security:authorize>
	</div>
	<div class="container">
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<td>Appointment id</td>
					<td>Date</td>
					<td>Room no</td>
					<security:authorize access="hasRole('ROLE_CHECKER')">
						<td>Reservations</td>
					</security:authorize>
					<security:authorize access="hasRole('ROLE_STUDENT')">
						<td>Make reservation</td>
					</security:authorize>
				</tr>
			</thead>
			<tbody class="table-striped">
				<c:forEach items="${appointments}" var="appointment">
					<tr>
						<td>${appointment.id}</td>
						<td>${appointment.date}</td>
						<td>${appointment.room_no}</td>
						<security:authorize access="hasRole('ROLE_CHECKER')">
							<td><a
								href="<c:url value="/reservations/byAppointmentId/${appointment.id}" />"
								class="btn btn-primary" type="button">View reservation list</a>
							</td>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_STUDENT')">
							<td>
								<button class="btn btn-info"
									id="reservationstatus${appointment.id }" type="button"
									value="${appointment.id}" onClick="makeReservation(this)">Make
									reservation</button>
							</td>
						</security:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="formInput" style="display: none"></div>

	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
         function makeReservation(e) {
          
             console.log(e.value);
             let appId = e.value;
             let url = "http://localhost:8080/IoC/reservations/makereservation/" + appId;
         
             $.ajax({
                 url: url,
                 method: "GET",
                 dataType: "json",
                 contentType: 'application/json',
                 success: (data) => {
                 	console.log(data);
                     if(data['status'] == "success"){
                                                 
                     	 $('#reservationstatus'+appId).addClass("btn btn-warning");
                         $('#reservationstatus'+appId).html("PENDING");
                         $('#reservationstatus'+appId).prop('disabled', true);
         
                         
                    	}                    
                 },
                 error: (err) => {
                     console.log(err);
                     alert("error");
                 }
             });
         }
         
      </script>
</body>
</html>