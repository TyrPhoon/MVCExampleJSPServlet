<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>Trang chủ</title>
</head>
<body>
        <h1 style="font-size: 50px"><center> Bài tập CN Web, Quản lý NVPB </center></h1>
	<%
	if (session.getAttribute("username") != null) {
	%>
	<h2 style="text-align: right"><%=session.getAttribute("username")%></h2>
	<%
	}
	%>
	<ol style="font-size: 30px">
            <li><a style="text-decoration: none" href="Controller_NV?Mod0='1'"> Xem thông tin nhân viên </a></li>
            <li><a style="text-decoration: none" href="Controller_PB?Mod1='1'"> Xem thông tin phòng ban </a></li>
            <li><a style="text-decoration: none" href="Controller_PB?Mod12='1'"> Cập nhật thông tin phòng ban </a></li>
            <li><a style="text-decoration: none" href="Controller_NV?Mod2='1'"> Tìm kiếm nhân viên </a></li>
            <li><a style="text-decoration: none" href="Controller_NV?Mod3='1'"> Thêm nhân viên </a></li>
            <li><a style="text-decoration: none" href="Controller_NV?Mod4='1'"> Cập nhật thông tin nhân viên </a></li>
            <li><a style="text-decoration: none" href="Controller_NV?Mod5='1'"> Xóa một nhân viên </a></li>
            <li><a style="text-decoration: none" href="Controller_NV?Mod6='1'"> Xóa nhiều nhân viên </a></li>
            <li><a style="text-decoration: none" href="index.jsp"> Đăng xuất </a></li>
    </ol>
</body>
</html>