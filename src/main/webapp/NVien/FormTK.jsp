<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		h3{
			background-color: blue;
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
			background-color: green;
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
		<h3>Tìm kiếm nhân viên</h3>
		<div id="form">
		<form action="<%=request.getContextPath()%>/Controller_NV" method="post">
			<table>
				<tr>
					<td>Chọn tiêu chí</td>
					<th><select name="TC" id="" width="100%">
							<option value="IDNV">IDNV</option>
							<option value="Name">NameNV</option>
							<option value="IDPB">IDPB</option>
							<option value="DC">Địa chỉ</option>
					</select></th>
				</tr>
				<tr>
					<td>Tư liệu tìm kiếm</td>
					<th><input type="text" name="Input"></th>
				</tr>
			</table>
			<input type="submit" name="search" value="OK"> <input
				type="reset" name="btnReset" value="Reset">
		</form>
		</div>
	<p>
		<a href="javascript:history.back()">Trang trước</a>
	</p>
</body>
</html>