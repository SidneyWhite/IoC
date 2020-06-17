<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
         
         ${currentUserId }
      </security:authorize>
      <h1>Appointment list</h1>
      <div>
      	<security:authorize access="hasRole('ROLE_CHECKER')">
         <a href="
         <c:url value="/appointments/add" />
         " class="btn btn-primary"
         type="button">Add new appointment</a>
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
                        <td>
                           <button class="btn btn-primary" type="button" onClick="getReservations(${appointment.id})">View reservation list</button>
                        </td>
                     </security:authorize>
                     <security:authorize access="hasRole('ROLE_STUDENT')">
                        <td>
                           <button class="btn btn-info" id="reservationstatus${appointment.id }" type="button" value="${appointment.id}" onClick="makeReservation(this)">Make reservation</button>
                        </td>
                     </security:authorize>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
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
         
         function getReservations(appointmentId){
             console.log(appointmentId);
             $.ajax({
                 url: "http://localhost:8080/IoC/appointments/getreservations/" + appointmentId,
				method: "GET",
				contentType: 'application/json',
				dataType: 'json',
				success: (data)=>{
					console.log(data);
					},
				error: (error)=>{
					console.log(error);
					alert(error)
					}
              });
         
         }
      </script>
   </body>
</html>