<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>添加员工信息</title>
		<link rel="stylesheet" type = "text/css" href = "css/style.css"/>
	</head>
	<body>
		<div id = "wrap">
			<div id = "top_content">
				<%@ include file = "header.jsp" %>
				<div id = "content">
					<p id = "whereami"></p>
					<h1>添加员工</h1>
					<form action="add.do" method = "post">
						<table cellpadding="0" cellspacing="0" border="0" class="form_table">
							<tr>
								<td valign = "middle" align = "right">姓名:</td>
								<td valign = "middle" align ="left">
									<input type="text" class="inputgri" name = "ename"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="left">薪水:</td>
								<td>
									<input type="text" class="inputgri" name="salary"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">年龄:</td>
								<td>
									<input type="text" class="inputgri" name="age" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定" />
						</p>
					</form>
				</div>
			</div>
			<%@ include file = "footer.jsp" %>
		</div>
	</body>
</html>