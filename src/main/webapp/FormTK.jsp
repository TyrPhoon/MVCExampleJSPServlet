<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body style="background-color: aquamarine;">

	<%
	if (session.getAttribute("username") != null) {
	%>
	<h2 style="text-align: right"><%=session.getAttribute("username")%></h2>
	<%
	}
	%>
	<center>
		<h2>Tìm kiếm nhân viên</h2>
		<form action="Controller_NV" method="post">
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
	</center>
	<p>
		<a href="javascript:history.back()">Trang trước</a>
	</p>
</body>
</html>