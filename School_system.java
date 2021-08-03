package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class School_system {
    public static void main(String[] args)throws IOException {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Welcome to school system");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1 for Student or 2 for Teacher");
        int school_input = scan1.nextInt();
        if (school_input==1) {
            while (true) {
                Scanner scan = new Scanner(System.in);
                int credit_hours = 0;

                System.out.println();
                System.out.println("press 1 to add student");
                System.out.println("press 2 to delete student");
                System.out.println("press 3 to display student");
                System.out.println("press 4 to update");
                System.out.println("press 5 for exit");
                int choice = Integer.parseInt(br.readLine());

                if (choice == 1) {
                    //add student
                    String[] courses = {" ", "PF", "OOP", "DSA", "CAL1", "English", "CAL2", "Linear Algebra", "COAL"};
                    ArrayList<String> selected_courses = new ArrayList<String>();

                    System.out.println("Enter Your name");
                    String name = scan.nextLine();

                    System.out.println("Enter Your Email");
                    String email = scan.nextLine();

                    System.out.println("Choose courses you want to learn");
                    for (int i = 1; i < courses.length; i++) {
                        System.out.print(i + ") " + courses[i] + ",");
                    }
                    for (int j = 0; j <= courses.length; j++) {
                        int choose_course = scan.nextInt();
                        System.out.println("Enter courses number or enter 0 to exit");
                        if (choose_course == 0) {
                            break;
                        } else if (credit_hours >= 21) {
                            System.out.println("You reached your credit hours limit");
                            break;
                        } else {
                            selected_courses.add(courses[choose_course]);
                            credit_hours = credit_hours + 3;
                        }
                    }
                    System.out.println("The courses you choosed");
                    System.out.println("Total credit hours you used: " + credit_hours);
                    System.out.println(selected_courses);

                    Student st = new Student(name, email, selected_courses);
                    Integer answer = StudentDB.insertStudenttoDB(st);
                    boolean answer1 = Student_coursesDB.insertCoursestoDB(st,answer);

                    if (answer1) {
                        System.out.println("Student is added successfully...");
                    } else {
                        System.out.println("Something went wrong");
                    }
                    System.out.println(st);
                } else if (choice == 2) {
                    //delete student
                    System.out.println("Enter Student id to delete");
                    int user_id = scan.nextInt();
                   boolean f = StudentDB.deleteStudent(user_id);
                   if (f){
                       System.out.println("Deleted...");
                   }else{
                       System.out.println("Something went wrong...");
                   }
                } else if (choice == 3) {
                    //display student
                    StudentDB.showAllStudent();
                } else if (choice == 4) {
                    //update
                    System.out.println("Enter Student id to update");
                    int user_id = scan.nextInt();
                    boolean f = StudentDB.updateStudent(user_id);
                    if (f){
                        System.out.println("Updated...");
                    }else{
                        System.out.println("Something went wrong...");
                    }
                } else if (choice == 5){
                     break;
                }
            }
        }
        else{

            while (true) {
                Scanner scan = new Scanner(System.in);
                int credit_hours = 0;

                System.out.println();
                System.out.println("press 1 to add Teacher");
                System.out.println("press 2 to delete Teacher");
                System.out.println("press 3 to display Teacher");
                System.out.println("press 4 to update");
                System.out.println("Press 5 for exit");
                int choice = Integer.parseInt(br.readLine());

                if (choice == 1) {
                    //add student
                    String[] courses = {" ", "PF", "OOP", "DSA", "CAL1", "English", "CAL2", "Linear Algebra", "COAL"};
                    ArrayList<String> selected_courses = new ArrayList<String>();

                    System.out.println("Enter Your name");
                    String name = scan.nextLine();

                    System.out.println("Enter Your Email");
                    String email = scan.nextLine();

                    System.out.println("Choose courses you want to Teach");
                    for (int i = 1; i < courses.length; i++) {
                        System.out.print(i + ") " + courses[i] + ",");
                    }
                    for (int j = 0; j <= courses.length; j++) {
                        int choose_course = scan.nextInt();
                        System.out.println("Enter courses number or enter 0 to exit");
                        if (choose_course == 0) {
                            break;
                        } else if (credit_hours >= 21) {
                            System.out.println("You reached your credit hours limit");
                            break;
                        } else {
                            selected_courses.add(courses[choose_course]);
                            credit_hours = credit_hours + 3;
                        }
                    }
                    System.out.println("The courses you choosed");
                    System.out.println("Total credit hours you used: " + credit_hours);
                    System.out.println(selected_courses);

                    Teacher t = new Teacher(name, email, selected_courses);
                    Integer answer = TeacherDB.insertTeachertoDB(t);
                    boolean answer1 = Teacher_CoursesDB.insertTCoursestoDB(t,answer);
                    if (answer1) {
                        System.out.println("Teacher is added successfully...");
                    } else {
                        System.out.println("Something went wrong");
                    }
                    System.out.println(t);
                } else if (choice == 2) {
                    //delete student
                    System.out.println("Enter Teacher id to delete");
                    int user_id = scan.nextInt();
                    boolean f = TeacherDB.deleteTeacher(user_id);
                    if (f){
                        System.out.println("Deleted...");
                    }else{
                        System.out.println("Something went wrong...");
                    }
                } else if (choice == 3) {
                    //display student
                    TeacherDB.showAllTeachers();
                } else if (choice == 4) {
                    //update
                    System.out.println("Enter Student id to update");
                    int user_id = scan.nextInt();
                    boolean f = TeacherDB.updateTeacher(user_id);
                    if (f){
                        System.out.println("Updated...");
                    }else{
                        System.out.println("Something went wrong...");
                    }
                } else {
                     break;
                }
            }
        }
        System.out.println("ThankYou for using school system");
    }
}

