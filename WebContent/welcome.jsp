<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<%@ include file ="head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="module.Inandout" %>
<title>RFID INFO</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div align="center">
	Welcome
	
	<table border="1" style="width:235px" >
	<td>id</td>
	<td>RFID</td>
	<td>MAC</td>
	<td>Date</td>
	<td>Time</td>
	<tr>
	<c:forEach items="${all}" var="c">
	<td>${c.id }</td>
	<td>${c.RFIDid }</td>
	<td>${c.MACid }</td>
	<td>${c.date }</td>
	<td>${c.time }</td>
	<tr>
	</c:forEach>
	<br>
	</table>
	<br>
	RFID info
	<table border="1" style="width:235px" >
	<td>id</td>
	<td>name</td>
	<tr>
	<c:forEach items="${RFID}" var="c">
	<td>${c.RFIDid }</td>
	<td>${c.empName }</td>
	<tr>
	</c:forEach>
	<br>
	</table>
	<br>
	MAC info
	<table border="1" style="width:235px" >
	<td>id</td>
	<td>name</td>
	<tr>
	<c:forEach items="${MAC}" var="c">
	<td>${c.MACid }</td>
	<td>${c.posName }</td>
	<tr>
	</c:forEach>
	<br>
	</table>
	<br>
	needtoAdd info
	<table border="1" style="width:235px" >
	<td>id</td>
	<td>type</td>
	<tr>
	<c:forEach items="${needtoAdd}" var="c">
	<td>${c.id }</td>
	<td>${c.type }</td>
	<tr>
	</c:forEach>
	<br>
	</table>
<br>
</div>
</body>
<footer>
<%@ include file ="footer.jsp" %>
</footer>
</html>
