<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录</title>
	</head>
	<body style="font-size:30px;">
		<form action="login.do" method = "post">
			<fieldset>
				<legend>登录</legend>
				用户名:<input name="username"/><br/>
				密码:<input type="password" name = "pwd"><br/>
				<input type = "submit" value="确定"/>
			</fieldset>
		</form>
	</body>
</html>