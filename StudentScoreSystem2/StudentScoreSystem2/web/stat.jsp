<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>成绩统计</title>
</head>
<body>
<h2>成绩统计信息</h2>
<%=request.getAttribute("statInfo")%>
<br><br>
<a href="score?action=index">返回菜单</a>
</body>
</html>