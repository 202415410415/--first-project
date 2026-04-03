<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.score.model.Student" %>
<html>
<head>
  <title>所有学生信息</title>
</head>
<body>
<h2>所有学生信息</h2>
<%
  List<Student> list = (List<Student>) request.getAttribute("studentList");
  if (list.isEmpty()) {
    out.write("暂无学生数据！");
  } else {
%>
<table border="1" cellpadding="5">
  <tr><th>学号</th><th>姓名</th><th>语文</th><th>数学</th><th>英语</th><th>总成绩</th></tr>
  <% for (Student s : list) { %>
  <tr>
    <td><%=s.getStuId()%></td>
    <td><%=s.getStuName()%></td>
    <td><%=s.getChinese()%></td>
    <td><%=s.getMath()%></td>
    <td><%=s.getEnglish()%></td>
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