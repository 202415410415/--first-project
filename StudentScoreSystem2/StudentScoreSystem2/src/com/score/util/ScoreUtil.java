package com.score.util;

import com.score.model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 模拟数据库：存储学生数据，提供增删改查方法
public class ScoreUtil {
    // 静态集合：全局共享，模拟数据库表
    public static List<Student> studentList = new ArrayList<>();

    // 1. 新增学生
    public static boolean addStudent(Student student) {
        // 先判断学号是否重复
        for (Student s : studentList) {
            if (s.getStuId().equals(student.getStuId())) {
                return false; // 学号重复，新增失败
            }
        }
        studentList.add(student);
        return true;
    }

    // 2. 按学号查询学生
    public static Student queryByStuId(String stuId) {
        for (Student s : studentList) {
            if (s.getStuId().equals(stuId)) {
                return s;
            }
        }
        return null; // 未找到
    }

    // 3. 获取所有学生
    public static List<Student> getAllStudents() {
        return studentList;
    }

    // 4. 修改学生成绩
    public static boolean updateScore(String stuId, int chinese, int math, int english) {
        Student student = queryByStuId(stuId);
        if (student != null) {
            student.setChinese(chinese);
            student.setMath(math);
            student.setEnglish(english);
            return true;
        }
        return false;
    }

    // 5. 删除学生
    public static boolean deleteStudent(String stuId) {
        Student student = queryByStuId(stuId);
        if (student != null) {
            studentList.remove(student);
            return true;
        }
        return false;
    }

    // 6. 按总成绩降序排序
    public static List<Student> sortByTotal() {
        List<Student> sortedList = new ArrayList<>(studentList);
        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getTotal() - s1.getTotal(); // 降序
            }
        });
        return sortedList;
    }

    // 7. 成绩统计：平均分、最高分、最低分
    public static String statScore() {
        if (studentList.isEmpty()) {
            return "暂无学生数据！";
        }
        int totalChinese = 0, totalMath = 0, totalEnglish = 0;
        int maxTotal = 0, minTotal = Integer.MAX_VALUE;

        for (Student s : studentList) {
            totalChinese += s.getChinese();
            totalMath += s.getMath();
            totalEnglish += s.getEnglish();
            maxTotal = Math.max(maxTotal, s.getTotal());
            minTotal = Math.min(minTotal, s.getTotal());
        }

        int count = studentList.size();
        double avgChinese = (double) totalChinese / count;
        double avgMath = (double) totalMath / count;
        double avgEnglish = (double) totalEnglish / count;

        return String.format(
                "语文平均分：%.1f，数学平均分：%.1f，英语平均分：%.1f<br>总成绩最高分：%d，最低分：%d",
                avgChinese, avgMath, avgEnglish, maxTotal, minTotal
        );
    }
}