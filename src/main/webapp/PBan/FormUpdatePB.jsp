<%@page import="Model.Bean.Phongban"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%
			if(session.getAttribute("username")!=null)
			{
		%>
	<h2 style="text-align: right"><%=session.getAttribute("username") %></h2>
	<%} %>
	<center>
		<h2>Cập nhật thông tin sinh viên</h2>
		<%
		Phongban pb = (Phongban)request.getAttribute("PB");
		%>
		<form action="<%=request.getContextPath()%>/Controller_PB" method="post">
			<table>
				<div>
					<table>
						<tr>
							<td>IDPB</td>
							<th><input type="text" name="IDPB"
								value="<%= pb.getIDPB() %>" readonly></th>
						</tr>
						<tr>
							<td>Tên PB</td>
							<th><input type="text" name="Name"
								value="<%= pb.getName() %>"></th>
						</tr>
						<tr>
							<td>Mô tả</td>
							<th><input type="text" name="Mota"
								value="<%= pb.getMota() %>"></th>
						</tr>
					</table>
					<input type="submit" name="updatepb" value="OK"> <input
						type="reset" name="btnReset" value="Reset">
				</div>
			</table>
		</form>
		<p>
			<a href="Welcome.jsp">Trang chủ</a>
		</p>
	</center>
</body>
</html>