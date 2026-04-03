package com.score.model;

// 学生实体类：封装学号、姓名、各科成绩、总成绩
public class Student {
    private String stuId;    // 学号
    private String stuName;  // 姓名
    private int chinese;     // 语文
    private int math;        // 数学
    private int english;     // 英语
    private int total;       // 总成绩（语文+数学+英语）

    // 构造方法
    public Student(String stuId, String stuName, int chinese, int math, int english) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.total = chinese + math + english;
    }

    // Getter和Setter（必须，JSP页面要取值）
    public String getStuId() { return stuId; }
    public void setStuId(String stuId) { this.stuId = stuId; }
    public String getStuName() { return stuName; }
    public void setStuName(String stuName) { this.stuName = stuName; }
    public int getChinese() { return chinese; }
    public void setChinese(int chinese) {
        this.chinese = chinese;
        this.total = chinese + this.math + this.english; // 同步更新总成绩
    }
    public int getMath() { return math; }
    public void setMath(int math) {
        this.math = math;
        this.total = this.chinese + math + this.english;
    }
    public int getEnglish() { return english; }
    public void setEnglish(int english) {
        this.english = english;
        this.total = this.chinese + this.math + english;
    }
    public int getTotal() { return total; }
}