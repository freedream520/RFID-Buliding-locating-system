<%@ page contentType="text/html; charset=utf-8" %>
<!--11303010126 ben_26-->

  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="index.jsp"><span class="am-icon-home"></span> 首页</a></li>
        <li><a href="newestPos?timestamp=<%= System.currentTimeMillis() %>"><span class="am-icon-location-arrow"></span> 实时位置</a></li>
        <li><a href="Event"><span class="am-icon-history"></span> 位置记录</a></li>
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-search"></span> 信息查询 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="selectbyemp" class="am-cf"><span class="am-icon-user"></span> 按人员</a></li>
            <li><a href="selectbypos"><span  class="am-icon-dot-circle-o"></span> 按位置</a></li>
            <li><a href="selectbydate"><span  class="am-icon-calendar"></span> 按日期</a></li>            
          </ul>
        </li>
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-pencil-square-o"></span> 信息修改 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
            <li><a href="alterbyemp" class="am-cf"><span class="am-icon-user"></span> 人员信息</a></li>
            <li><a href="alterbypos"><span  class="am-icon-dot-circle-o"></span> 位置信息</a></li>         
          </ul>
        </li>
        <li><a href="needtoAdd"><span class="am-icon-plus"></span> 信息添加</a></li>
      </ul>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> RFID课程设计</p>
          <p>厉叶挺<br/>田创宇<br/>邓振鹏<br/></p>
        </div>
      </div>

    </div>
  </div>