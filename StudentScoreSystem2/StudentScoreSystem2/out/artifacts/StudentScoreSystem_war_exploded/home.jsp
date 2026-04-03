<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩管理系统-首页</title>
    <style>
        body {
            font-family: "Microsoft YaHei", sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #2c3e50;
            color: white;
            padding: 20px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
        }
        .container {
            width: 80%;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .menu-btn {
            display: inline-block;
            margin: 10px;
            padding: 12px 24px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .menu-btn:hover {
            background-color: #2980b9;
        }
        .footer {
            text-align: center;
            margin-top: 50px;
            color: #7f8c8d;
        }
    </style>
</head>
<body>
<div class="header">学生成绩管理系统</div>
<div class="container">
    <h2>欢迎使用学生成绩管理系统</h2>
    <p>请选择下方功能模块进行操作：</p>
    <a href="score?action=addPage" class="menu-btn">录入学生信息</a>
    <a href="score?action=list" class="menu-btn">查看所有信息</a>
    <a href="score?action=updatePage" class="menu-btn">修改成绩</a>
    <a href="score?action=deletePage" class="menu-btn">删除信息</a>
    <a href="score?action=sort" class="menu-btn">成绩排序</a>
    <a href="score?action=stat" class="menu-btn">成绩统计</a>
</div>
<div class="footer">第三组版权所有</div>
</body>
</html>