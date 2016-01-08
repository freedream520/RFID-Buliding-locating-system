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
	<s:property value="#title"/>
	<table border="1" style="width:330px;text-align:center"" >
	<td>id</td>
	<td>name</td>
	<td></td>
	<td></td>
	<tr>
	<c:forEach items="${MAC}" var="c">
	<td>${c.MACid }</td>
	<form action="alterbypos" method="get" >
			<input type="hidden" value=${c.MACid } name="choicePos" style="color:black"/>
			<td><input value=${c.posName } name="posName" style="color:black"/></td>				
			<td><input type="submit" value="修改" style="color:black"/></td>					
	</form>	
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
