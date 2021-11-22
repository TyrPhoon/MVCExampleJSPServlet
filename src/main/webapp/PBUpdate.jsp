<%@page import="Model.Bean.Phongban"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList"%>
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
	<table border="1" width="100%">
		<caption>Danh sách phòng ban</caption>
		<tr>
			<th>IDPB</th>
			<th>Tên PB</th>
			<th>Mô tả</th>
			<th>Cập nhật</th>
		</tr>
		<%
		ArrayList<Phongban> ArrayNV = (ArrayList<Phongban>) request.getAttribute("AllPB");
		for (int i = 0; i < ArrayNV.size(); i++) {
		%>
		<tr>
			<td><%=ArrayNV.get(i).getIDPB()%></td>
			<td><%=ArrayNV.get(i).getName()%></td>
			<td><%=ArrayNV.get(i).getMota()%></td>
			<td><a
				href="Controller_PB?IDPBUD=<%=ArrayNV.get(i).getIDPB()%>"> Thay
					đổi </a></td>
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