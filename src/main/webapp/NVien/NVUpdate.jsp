<%@page import="Model.Bean.Nhanvien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="Model.Bean.Nhanvien"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
	<style type="text/css">
		h3{
			background-color: blue;
			padding: 10px 0 10px 10px;
		}
		.nhanviens{
			border-collapse: collapse;
			width: 100%;
		}
		.nhanviens th, .nhanviens td{
			border: 1px solid;
			padding: 5px;
		}
		.nhanviens th{
			background-color: yellow;
		}
		.nhanviens td{
			background-color: aqua;
		}
	</style>
</head>
<body>

	<%
	if (session.getAttribute("username") != null) {
	%>
	<h2 style="text-align: right"><%=session.getAttribute("username")%></h2>
	<%
	}
	%>
	<h3>Danh sách nhân viên</h3>
	<table class="nhanviens">
		<tr>
			<th>IDNV</th>
			<th>Họ tên</th>
			<th>IDPB</th>
			<th>Địa chỉ</th>
			<th>Cập nhật</th>
		</tr>
		<%
		ArrayList<Nhanvien> ArrayNV = (ArrayList<Nhanvien>) request.getAttribute("AllNV");
		for (int i = 0; i < ArrayNV.size(); i++) {
		%>
		<tr>
			<td><%=ArrayNV.get(i).getIDNV()%></td>
			<td><%=ArrayNV.get(i).getName()%></td>
			<td><%=ArrayNV.get(i).getIDPB()%></td>
			<td><%=ArrayNV.get(i).getDiaChi()%></td>
			<td><a
				href="Controller_NV?IDNVUD=<%=ArrayNV.get(i).getIDNV()%>"> Cập
					nhật </a></td>
		</tr>
		<%
		}
		%>
	</table>
	<p>
		<a href="Welcome.jsp">Trang chủ</a>
	</p>
</body>
</html>