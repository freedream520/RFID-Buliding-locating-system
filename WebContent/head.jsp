<%@ page contentType="text/html; charset=utf-8" %>
<!--11303010126 ben_26-->
<head>
<link href="css/styleNav.css" type="text/css" rel="stylesheet">
</head>
<div align="center"> <!-- align="center" -->
	<br/><H>RFID</H>
	<nav id='' style=""><!-- width:235px -->
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="ManualEvent.jsp">ManualEvent</a></li>
			<li><a href="newestPos?timestamp=<%= System.currentTimeMillis() %>">实时位置</a></li>
			<li><a href="Event">位置记录</a></li>
			<li><a href="selectbyemp">查询员工</a></li>
			<li><a href="selectbypos">查询位置</a></li>
			<li><a href="selectbydate">查询日期</a></li>
			<li><a href="ManualAction?RFIDid=111&MACid=111">BackStage</a></li>
		</ul>
	</nav>
</div>