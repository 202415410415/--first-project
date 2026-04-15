<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>删除学生信息</title>
</head>
<body>
<h2>删除学生信息</h2>
<form action="score?action=delete" method="post">
    请输入要删除的学号：<input type="text" name="stuId" required>
    <input type="submit" value="删除">
</form>
<br>
<a href="score?action=index">返回菜单</a>
</body>
</html>