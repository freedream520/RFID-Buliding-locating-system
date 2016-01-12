<%@ page contentType="text/html; charset=utf-8"%><!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>RFID 课程设计后台</title>
<meta name="description" content="RFID 课程设计后台">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="RFID 课程设计后台" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<header class="am-topbar admin-header">
		<div class="am-topbar-brand">
			<strong>RFID </strong> <small>课程设计后台</small>
		</div>

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

			<ul
				class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
				<li class="am-hide-sm-only"><a href="javascript:;"
					id="admin-fullscreen"><span class="am-icon-arrows-alt"></span>
						<span class="admin-fullText">开启全屏</span></a></li>
			</ul>
		</div>
	</header>

<div class="am-cf admin-main" >
		  <!-- sidebar start -->
<%@ include file="head2.jsp"%>
  <!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">

			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">首页</strong> / <small>按位置查询</small>
				</div>

				<div class="am-u-sm-12 am-u-md-3">
					<form action="selectbypos" method="get">
						<div class="am-input-group am-input-group-sm">
							<select name="choicePos" data-am-selected="{btnSize: 'sm'}">
								<option value="ALL">所有</option>
								<c:forEach items="${MAC}" var="c">
									<option value=${c.MACid}>${c.posName }</a></option>
								</c:forEach>
							</select> 
							<span class="am-input-group-btn">
								<button class="am-btn am-btn-default" type="submit">查询</button>
							</span>
						</div>
					</form>
				</div>


				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<tr>

					<div class="am-g">
						<div class="am-u-sm-12">
							<table class="am-table am-table-bd am-table-striped admin-content-table">
								<thead>
									<tr>
										<th>员工编号</th>
										<th>姓名</th>
										<th>位置</th>
										<th>日期</th>
										<th>时间</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${all}" var="c">
										<tr>
											<td>${c.RFIDid }</td>
											<td>${c.empName }</td>
											<td>${c.posName }</td>
											<td>${c.d }</td>
											<td>${c.t }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
			</div>
			<!-- content end -->

		</div>

		<a href="#" class="am-show-sm-only admin-menu"
			data-am-offcanvas="{target: '#admin-offcanvas'}"> <span
			class="am-icon-btn am-icon-th-list"></span>
		</a>

		<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

		<!--[if (gte IE 9)|!(IE)]><!-->
		<script src="assets/js/jquery.min.js"></script>
		<!--<![endif]-->
		<script src="assets/js/amazeui.min.js"></script>
		<script src="assets/js/app.js"></script>
</body>
<footer>
<%@ include file="footer.jsp"%>
</footer>
</html>
