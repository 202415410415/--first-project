<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.score.model.Student" %>
<html>
<head>
    <title>按总成绩排序</title>
</head>
<body>
<h2>学生成绩（按总成绩降序）</h2>
<%
    List<Student> sortedList = (List<Student>) request.getAttribute("sortedList");
    if (sortedList.isEmpty()) {
        out.write("暂无学生数据！");
    } else {
%>
<table border="1" cellpadding="5">
    <tr><th>排名</th><th>学号</th><th>姓名</th><th>总成绩</th></tr>
    <% for (int i=0; i<sortedList.size(); i++) {
        Student s = sortedList.get(i);
    %>
    <tr>
        <td><%=i+1%></td>
        <td><%=s.getStuId()%></td>
        <td><%=s.getStuName()%></td>
        <td><%=s.getTotal()%></td>
    </tr>
    <% } %>
</table>
<%
    }
%>
<br>
<a href="score?action=index">返回菜单</a>
</body>
</html>