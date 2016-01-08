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
	<td>type</td>
	<td>name</td>
	<td></td>
	<tr>
	<c:forEach items="${needtoAdd}" var="c">
	<td>${c.id }</td>
	<td>${c.type }</td>
	<form action="needtoAdd" method="get" >
			<input type="hidden" value=${c.id } name="choiceEmp" style="color:black"/>
			<input type="hidden" value=${c.type } name="choicePos" style="color:black"/>
			<td><input name="empName" style="color:black"/></td>				
			<td><input type="submit" value="添加"  style="color:black"/></td>				
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
