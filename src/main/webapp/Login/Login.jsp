
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style type="text/css">
		div.login {
			width: 800px;
			height: 350px;
			border: 1px solid grey;
			/*border-radius: 30px;
			text-align: center;
			background-color: aqua;*/
			margin: 0 auto
		}
		p{
			margin-left: 50px;
			color: black;
			font-family: sans-serif;
		}
		h1{
			
			margin-left: 50px;
			color: red;
			font-family: sans-serif;
		}
		input {
			width: 600px;
			height: 30px;
			display: inline-block;
			margin-left: 50px;
			margin-bottom: 10px;
			padding-left: 15px;
		}
		
		input[type=submit]{
			width: 80px;
			padding: 5px 0;
			margin: 5px 5px;
			margin-left:50px;
			border: 1px solid;
			border-radius: 3px;
			background-color: rgb(106, 231, 106);
			display: inline;
			}
		input[type=submit]:hover{
			background-color: aqua;
		}
		input[type=reset]{
			width: 80px;
			padding: 5px 0;
			margin: 5px 5px;
			border: 1px solid;
			border-radius: 3px;
			background-color: red;
			}
		input[type=reset]:hover{
			background-color: aqua;
		}
		h3{
		color: red;
		}
	</style>
</head>
<body>

		<div class = "login" >
		<h1>Login</h1>
		<%
		if (request.getAttribute("message") != null) {
		%>
		<p style="color: red"><%=request.getAttribute("message")%></p>
		<%
		}
		%>
		<form name="form1" action ="<%=request.getContextPath()%>/CheckLoginServlet"  method = "post">
			<p>Password</p>
            <input type="text" name="username" placeholder="Username" >
            <p>Password</p>
            <input type="password" name="password" placeholder="Password"><br>
            <input type="submit" name="btnOK" value="Login" >
            <input type="reset" name="btnReset" value="Reset">
   		</form>
	</div>
</body>
</html>