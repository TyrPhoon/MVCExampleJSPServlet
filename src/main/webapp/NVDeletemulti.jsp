<%@page import="Model.Bean.Nhanvien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="Model.Bean.Nhanvien"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>


	<%
	if (session.getAttribute("username") != null) {
	%>
	<h2 style="text-align: right"><%=session.getAttribute("username")%></h2>
	<%
	}
	%>
	<form action="Controller_NV" method="post">
		<table border="1" width="100%">
			<caption>Danh sách nhân viên</caption>
			<tr>
				<th>IDNV</th>
				<th>Họ tên</th>
				<th>IDPB</th>
				<th>Địa chỉ</th>
				<th>Chọn</th>
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
				<td><input type="checkbox" name="MaNV"
					value="<%=ArrayNV.get(i).getIDNV()%>"></td>
			</tr>
			<%
			}
			%>
			<tr align="right">
				<td colspan="5"><input type="submit" name="Xoanhieu"
					value="Xoa tat ca"></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="Welcome.jsp">Trang chủ</a>
	</p>

</body>
</html>