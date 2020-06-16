<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Appointment</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>

<body style="margin-left: 10px">
    <h1>Appointment list</h1>
    <div>
        <a href="<c:url value="/appointments/add" />" class="btn btn-primary" type="button">Add new appointment</a>
    </div>
    <div class="container">
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <td>Appointment id</td>
                    <td>Date</td>
                    <td>Room no</td>
                    <td>Reservations</td>
                    <td>Make reservation</td>
                </tr>
            </thead>
            <tbody class="table-striped">
                <c:forEach items="${appointments}" var="appointment">
                    <tr>
                        <td>${appointment.id}</td>
                        <td>${appointment.date}</td>
                        <td>${appointment.room_no}</td>
                        <td>
                            <button class="btn btn-primary" type="button">View reservation list</button>
                        </td>

                        <td>
                            <button class="btn btn-info" type="button" value="${appointment.id}" onClick="makeReservation(this)">Make reservation</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script>
        function makeReservation(e) {
            console.log(e.value);
            let appId = e.value;
            let url = "http://localhost:8080/IoC/reservations/makereservation/" + appId;

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