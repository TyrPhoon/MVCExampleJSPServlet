<%@page import="Model.Bean.Phongban"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList"%>
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
		<h2>Thêm sinh viên</h2>
		<form action="Controller_NV" method="post">
			<table>
				<div>
					<table>
						<tr>
							<td>IDNV</td>
							<th><input type="text" name="IDNV" placeholder="Điền IDNV">
							</th>
						</tr>
						<tr>
							<td>Tên NV</td>
							<th><input type="text" name="Name"
								placeholder="Điền tên nhân viên"></th>
						</tr>
						<tr>
							<td>IDPB</td>
							<th><select name="IDPB" id="" width="100%">
									<%
								ArrayList<Phongban> allpb=(ArrayList<Phongban>)request.getAttribute("AllPB");
								for(int i=0;i< allpb.size();i++)
								{
								%>
									<option value="<%=allpb.get(i).getIDPB() %>">
										<%=allpb.get(i).getIDPB() %>
									</option>
									<%}
									%>
							</select></th>
						</tr>
						<tr>
							<td>Địa Chỉ</td>
							<th><input type="text" name="DC"
								placeholder="Địa chỉ nhân viên"></th>
						</tr>
					</table>
					<input type="submit" name="insert" value="OK"> <input
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