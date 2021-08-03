package com.company;

import java.util.ArrayList;

public class Teacher {
    private String teacherName;
    private String teacherEmail;
    private ArrayList<String> courses;
    //    private ArrayList<Integer> credit;
    private int teacher_id;

    public String getTeacherName() {
        return teacherName;
    }

    public void setStudentName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String studentEmail) {
        this.teacherEmail = studentEmail;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }


    public Teacher(String studentName, String studentEmail, ArrayList<String> courses) {
        super();
        this.teacherName = studentName;
        this.teacherEmail = studentEmail;
        this.courses = courses;
    }
}
