<%@page import="Model.Bean.Phongban"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
	<style type="text/css">
		h3{
			background-color: rgb(0, 174, 255);
			padding: 10px 0 10px 10px;
		}
		.phongbans{
			border-collapse: collapse;
			width: 100%;
		}
		.phongbans th, .phongbans td{
			border: 1px solid;
			padding: 5px;
		}
		.phongbans th{
			background-color: yellow;
		}
		.phongbans td{
			background-color: aqua;
		}
	</style>
</head>
<body>
	<%
			if(session.getAttribute("username")!=null)
			{
		%>
			<h2 style="text-align: right"><%=session.getAttribute("username") %></h2>
		<%} %>
		
	<h3>Danh sách phòng ban</h3>
	<table class="phongbans">
	<tr><th>IDPB</th><th>Tên PB</th><th>Mô tả</th><th>Chi tiết</th></tr>
		<%
		ArrayList<Phongban> ArrayNV=(ArrayList<Phongban>)request.getAttribute("AllPB");
		for(int i=0;i< ArrayNV.size();i++)
		{
		%>
		<tr>
			<td><%=ArrayNV.get(i).getIDPB()%></td>
			<td><%=ArrayNV.get(i).getName() %></td>
			<td><%=ArrayNV.get(i).getMota()%></td>
			<td><a href="Controller_NV?IDPB=<%=ArrayNV.get(i).getIDPB() %>"> Xem chi tiết </a></td>
		</tr>
		<%}
		%>
	</table>
	<p><a href="javascript:history.back()">Trang trước</a></p>
</body>
</html>