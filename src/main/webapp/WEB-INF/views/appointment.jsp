<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Appointment works</h1>

<c:forEach items="${appointments}" var="appointment">

	<h5>${appointment.id}</h5>
	<h5>${appointment.date}</h5>
	<h5>${appointment.room_no}</h5>


</c:forEach>
</body>
</html>