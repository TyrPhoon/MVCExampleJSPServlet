<%@page import="Model.Bean.Nhanvien"%>
<%@page import="Model.Bean.Phongban"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		h3{
			background-color: rgb(0, 174, 255);
			padding: 10px 0 10px 10px;
		}
		#form{
			width: 500px;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
		}
		input[type=text]{
			width: 400px;
			padding: 10px 0;
			margin: 5px 5px;
			display: inline-block;
			box-sizing: border-box;
			padding-left: 15px;
			border: 1px solid;
			border-radius: 5px;
		}
		select{
			width: 400px;
			padding: 10px 0;
			margin: 5px 5px;
			display: inline-block;
			box-sizing: border-box;
			padding-left: 15px;
			border: 1px solid;
			border-radius: 5px;
		}
		input[type=submit]{
			width: 80px;
			padding: 10px 0;
			margin: 5px 5px;
			border: 1px solid;
			border-radius: 3px;
			background-color: rgb(106, 231, 106);
			}
		input[type=submit]:hover{
			background-color: aqua;
		}
		input[type=reset]{
			width: 80px;
			padding: 10px 0;
			margin: 5px 5px;
			border: 1px solid;
			border-radius: 3px;
			background-color: red;
			}
		input[type=reset]:hover{
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
		<h3>Cập nhật thông tin sinh viên</h3>
		<%
		Nhanvien nv = (Nhanvien) request.getAttribute("NV");
		%>
		<div id="form">
		<form action="<%=request.getContextPath()%>/Controller_NV" method="post">
			<table>
				<div>
					<table>
						<tr>
							<td>IDNV</td>
							<th><input type="text" name="IDNV" value="<%=nv.getIDNV()%>"
								readonly></th>
						</tr>
						<tr>
							<td>Tên NV</td>
							<th><input type="text" name="Name" value="<%=nv.getName()%>"></th>
						</tr>
						<tr>
							<td>IDPB</td>
							<th><select name="IDPB" id="" width="100%">
									<%
									ArrayList<Phongban> allpb = (ArrayList<Phongban>) request.getAttribute("AllPB");
									for (int i = 0; i < allpb.size(); i++) {
									%>
									<option value="<%=allpb.get(i).getIDPB()%>">
										<%=allpb.get(i).getIDPB()%>
									</option>
									<%
									}
									%>
							</select></th>
						</tr>
						<tr>
							<td>Địa chỉ</td>
							<th><input type="text" name="DC" value="<%=nv.getDiaChi()%>"></th>
						</tr>
					</table>
					<input type="submit" name="update" value="OK"> <input
						type="reset" name="btnReset" value="Reset">
				</div>
			</table>
		</form>
		</div>
		<p>
			<a href="Welcome.jsp">Trang chủ</a>
		</p>
</body>
</html>