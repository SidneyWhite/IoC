<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Appointment</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
   </head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
   </head>
   <body>
   	<h1>Appointment add</h1>
   	
   	<div class="container">
   		<form:form modelAttribute="newAppointment"  method="POST">
   		
   			<form:errors path="*" cssClass="alert alert-danger" element="div"/>
   			
   			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="date"> Appointment Date</label>
				<div class="col-lg-10">
					<form:input id="appointmentDate" path="date" type="date" class="form:input-large"/>
					<form:errors path="date" cssClass="text-danger"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="roomno">Room № </label>
				<div class="col-lg-10">
					<form:input id="roomno" path="room_no" type="text" class="form:input-large"/>
					<form:errors path="room_no" cssClass="text-danger"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
				</div>
			</div>
			
   		
   		
   		</form:form>
   	
   	
   	</div>
   
      
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
   </body>
</html>