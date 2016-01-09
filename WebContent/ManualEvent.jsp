<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<%@ include file ="head.jsp" %>
<title>ManualEvent</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div align="center">
	<form action="ManualAction" method="get" >
		<div class="form" style="height:18.5em">
			<%@ taglib uri="/struts-tags" prefix="s" %>
			<font color="red"><s:fielderror/></font>
			<div class="username">
				<input type="text" placeholder="RFIDid" name="RFIDid"/>
			</div>
			<div class="password">
				<input type="text" placeholder="MACid" name="MACid"/>
			</div>
			<div class="password2">
				<input type="submit" value="manual add"/>
			</div>
		</div>
		<br/>
	</form>
</div>
</body>
</html>