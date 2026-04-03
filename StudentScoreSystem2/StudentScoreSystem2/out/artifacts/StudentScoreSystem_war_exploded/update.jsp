<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改学生成绩</title>
</head>
<body>
<h2>修改学生成绩</h2>
<form action="score?action=update" method="post">
    学号：<input type="text" name="stuId" required><br><br>
    新语文成绩：<input type="number" name="chinese" min="0" max="100" required><br><br>
    新数学成绩：<input type="number" name="math" min="0" max="100" required><br><br>
    新英语成绩：<input type="number" name="english" min="0" max="100" required><br><br>
    <input type="submit" value="修改">
</form>
<br>
<a href="score?action=index">返回菜单</a>
</body>
</html>