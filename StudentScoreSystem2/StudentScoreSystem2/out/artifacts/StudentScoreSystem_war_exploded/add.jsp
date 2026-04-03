<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>录入学生信息</title>
</head>
<body>
<h2>录入学生信息</h2>
<form action="score?action=add" method="post">
    学号：<input type="text" name="stuId" required><br><br>
    姓名：<input type="text" name="stuName" required><br><br>
    语文：<input type="number" name="chinese" min="0" max="100" required><br><br>
    数学：<input type="number" name="math" min="0" max="100" required><br><br>
    英语：<input type="number" name="english" min="0" max="100" required><br><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
<br>
<a href="score?action=index">返回菜单</a>
</body>
</html>