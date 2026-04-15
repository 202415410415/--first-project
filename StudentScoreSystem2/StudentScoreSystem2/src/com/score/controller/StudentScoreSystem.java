package com.score.controller;

import com.score.model.Student;
import com.score.util.ScoreUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentScoreSystem extends HttpServlet {
        @Override
        protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");

            // 获取请求参数：action=add/query/list等（对应菜单功能）
            String action = req.getParameter("action");
            if (action == null) {
                action = "index"; // 默认跳首页
            }

            // 按action分发功能
            switch (action) {
                case "index": // 首页
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                    break;
                case "addPage": // 跳录入页面
                    req.getRequestDispatcher("/add.jsp").forward(req, resp);
                    break;
                case "add": // 执行录入
                    addStudent(req, resp);
                    break;
                case "queryPage": // 跳查询页面
                    req.getRequestDispatcher("/query.jsp").forward(req, resp);
                    break;
                case "query": // 执行查询
                    queryStudent(req, resp);
                    break;
                case "list": // 显示所有学生
                    listAllStudents(req, resp);
                    break;
                case "updatePage": // 跳修改页面
                    req.getRequestDispatcher("/update.jsp").forward(req, resp);
                    break;
                case "update": // 执行修改
                    updateScore(req, resp);
                    break;
                case "deletePage": // 跳删除页面
                    req.getRequestDispatcher("/delete.jsp").forward(req, resp);
                    break;
                case "delete": // 执行删除
                    deleteStudent(req, resp);
                    break;
                case "sort": // 按总成绩排序
                    sortByTotal(req, resp);
                    break;
                case "stat": // 成绩统计
                    statScore(req, resp);
                    break;
                case "exit": // 退出（返回首页）
                    resp.sendRedirect("/");
                    break;
                default:
                    resp.getWriter().write("无效的操作！");
            }
        }

        // 适配表单POST提交（新增/修改/删除）
        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }

        // 1. 录入学生信息
        private void addStudent (HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String stuId = req.getParameter("stuId");
            String stuName = req.getParameter("stuName");
            int chinese = Integer.parseInt(req.getParameter("chinese"));
            int math = Integer.parseInt(req.getParameter("math"));
            int english = Integer.parseInt(req.getParameter("english"));

            Student student = new Student(stuId, stuName, chinese, math, english);
            boolean success = ScoreUtil.addStudent(student);

            if (success) {
                resp.getWriter().write("录入成功！<br><a href='?action=index'>返回菜单</a>");
            } else {
                resp.getWriter().write("学号重复，录入失败！<br><a href='?action=addPage'>重新录入</a>");
            }
        }

        // 2. 按学号查询学生
        private void queryStudent (HttpServletRequest req, HttpServletResponse resp) throws
        ServletException, IOException {
            String stuId = req.getParameter("stuId");
            Student student = ScoreUtil.queryByStuId(stuId);

            req.setAttribute("student", student); // 把查询结果传给JSP
            req.getRequestDispatcher("/query.jsp").forward(req, resp);
        }

        // 3. 显示所有学生
        private void listAllStudents (HttpServletRequest req, HttpServletResponse resp) throws
        ServletException, IOException {
            List<Student> list = ScoreUtil.getAllStudents();
            req.setAttribute("studentList", list);
            req.getRequestDispatcher("/list.jsp").forward(req, resp);
        }

        // 4. 修改学生成绩
        private void updateScore (HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String stuId = req.getParameter("stuId");
            int chinese = Integer.parseInt(req.getParameter("chinese"));
            int math = Integer.parseInt(req.getParameter("math"));
            int english = Integer.parseInt(req.getParameter("english"));

            boolean success = ScoreUtil.updateScore(stuId, chinese, math, english);
            if (success) {
                resp.getWriter().write("修改成功！<br><a href='?action=index'>返回菜单</a>");
            } else {
                resp.getWriter().write("学号不存在，修改失败！<br><a href='?action=updatePage'>重新修改</a>");
            }
        }

        // 5. 删除学生信息
        private void deleteStudent (HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String stuId = req.getParameter("stuId");
            boolean success = ScoreUtil.deleteStudent(stuId);

            if (success) {
                resp.getWriter().write("删除成功！<br><a href='?action=index'>返回菜单</a>");
            } else {
                resp.getWriter().write("学号不存在，删除失败！<br><a href='?action=deletePage'>重新删除</a>");
            }
        }

        // 6. 按总成绩排序
        private void sortByTotal (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            List<Student> sortedList = ScoreUtil.sortByTotal();
            req.setAttribute("sortedList", sortedList);
            req.getRequestDispatcher("/sort.jsp").forward(req, resp);
        }

        // 7. 成绩统计
        private void statScore (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String statInfo = ScoreUtil.statScore();
            req.setAttribute("statInfo", statInfo);
            req.getRequestDispatcher("/stat.jsp").forward(req, resp);
        }
    }

