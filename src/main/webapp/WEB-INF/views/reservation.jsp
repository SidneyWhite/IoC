<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
					<td>Status</td>
					<td></td>
				</tr>
			</thead>
			<tbody class="table-striped">
				<c:forEach items="${reservations}" var="reservation">
					<tr>
						<td>${reservation.id}</td>
						<td>${reservation.appointment.id}</td>
						<td>${reservation.appointment.date}</td>
						<td>${reservation.appointment.room_no}</td>
						<td>${reservation.status}</td>
						<td>
							<security:authorize access="hasRole('ROLE_CHECKER')">
								<button class="btn btn-info" type="button"
									value="${reservation.id}" onClick="acceptReservation(this)">accept</button>
							</security:authorize>
							<security:authorize access="hasRole('ROLE_STUDENT')">
								<button class="btn btn-info" type="button"
									value="${reservation.id}" onClick="deleteReservation(this)">delete</button>

							</security:authorize>
						</td>
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
        function acceptReservation(e) {
            console.log(e.value);
            let resId = e.value;
            let url = "http://localhost:8080/IoC/reservations/acceptreservation/" + resId;

            $.ajax({
                url: url,
                method: "GET",
                success: (data) => {
                    console.log(data);
                    alert("success");
                },
                error: () => {
                    alert("error");
                }
            });
        }

        function deleteReservation(e) {
            console.log(e.value);
            let resId = e.value;
            let url = "http://localhost:8080/IoC/reservations/deletereservation/" + resId;

            $.ajax({
                url: url,
                method: "GET",
                success: (data) => {
                    console.log(data);
                    alert("success");
                },
                error: () => {
                    alert("error");
                }
            });
        }
    </script>
</body>
</html>