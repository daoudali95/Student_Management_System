package com.company;

import java.util.ArrayList;

public class Student {
    private String studentName;
    private String studentEmail;
    private ArrayList<String> courses;
//    private ArrayList<Integer> credit;
    private int student_id;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }


    public Student(String studentName, String studentEmail, ArrayList<String> courses) {
        super();
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.courses = courses;
    }

    public Student(ArrayList<String> courses) {
        this.courses = courses;
    }

    public Student(){
        super();
    }
}
