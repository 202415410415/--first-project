<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.score.model.Student" %>
<html>
<head>
    <title>按学号查询</title>
</head>
<body>
<h2>按学号查询学生</h2>
<form action="score?action=query" method="get">
    请输入学号：<input type="text" name="stuId" required>
    <input type="submit" value="查询">
</form>
<br>

<%-- 显示查询结果 --%>
<%
    Student student = (Student) request.getAttribute("student");
    if (student != null) {
%>
<table border="1" cellpadding="5">
    <tr><th>学号</th><th>姓名</th><th>语文</th><th>数学</th><th>英语</th><th>总成绩</th></tr>
    <tr>
        <td><%=student.getStuId()%></td>
        <td><%=student.getStuName()%></td>
        <td><%=student.getChinese()%></td>
        <td><%=student.getMath()%></td>
        <td><%=student.getEnglish()%></td>
        <td><%=student.getTotal()%></td>
    </tr>
</table>
<%
    } else if (request.getParameter("stuId") != null) {
        out.write("未找到该学号的学生！");
    }
%>
<br>
<a href="score?action=index">返回菜单</a>
</body>
</html>