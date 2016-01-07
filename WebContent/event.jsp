<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<%@ include file ="head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="module.Inandout" %>
			<%@ taglib uri="/struts-tags" prefix="s" %>
<title>RFID INFO</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div align="center">
	<s:property value="#title"/>
	<table border="1" style="width:330px;text-align:center"" >
	<td>员工编号</td>
	<td>姓名</td>
	<td>位置</td>
	<td>日期</td>
	<td>时间</td>
	<tr>
	<c:forEach items="${all}" var="c">
	<td>${c.RFIDid }</td>
	<td>${c.empName }</td>
	<td>${c.posName }</td>
	<td>${c.d }</td>
	<td>${c.t }</td>
	<tr>
	</c:forEach>
	<br>
	</table>
	<br>
<br>
</div>
</body>
<footer>
<%@ include file ="footer.jsp" %>
</footer>
</html>
