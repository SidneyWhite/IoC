<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body style="margin-left: 10px">
	<h1>Reservation list</h1>

	<div class="container">
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<td>Reservation id</td>
					<td>Appointment id</td>
					<td>Date</td>
					<td>Room no</td>
				</tr>
			</thead>
			<tbody class="table-striped">
				<c:forEach items="${reservations}" var="reservation">
					<tr>
						<td>${reservation.id}</td>
						<td>${reservation.appointment.id}</td>
						<td>${reservation.appointment.date}</td>
						<td>${reservation.appointment.room_no}</td>
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
</body>
</html>