<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<%@ include file ="head.jsp" %>
<title>Register</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div align="center">
	<form action="Register" method="post" >
		<div class="form" >
			<%@ taglib uri="/struts-tags" prefix="s" %>
			<font color="red"><s:fielderror/></font>
			<div class="username">
				<input type="text" placeholder="USERNAME" name="name"/>
			</div>
			<div class="password">
				<input type="password" placeholder="PASSWORD" name="password"/>
			</div>
			<div class="password2">
				<input type="password" placeholder="PASSWORD" name="password2"/>
			</div>
			<div class="password3">
				<input type="submit" value="SIGN IN"/>
			</div>
		</div>
		<br/><br/><br/>
	</form>
</div>

</body>
<footer>
<%@ include file ="footer.jsp" %>
</footer>
</html>