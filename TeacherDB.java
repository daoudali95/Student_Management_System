package com.company;

import java.sql.*;
import java.util.Scanner;

public class TeacherDB {
    public static int insertTeachertoDB(Teacher t){
        Integer id = null;
        //jdbc code...
        try {
            Connection con = DB.creatDB();
            //query
            String q = "insert into teacher(name, email) values("+"'"+t.getTeacherName()+"'"+","+"'"+t.getTeacherEmail()+"'"+")";
            PreparedStatement pstm = con.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

            //Execution...
            int affectedRows = pstm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id =  (generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public static boolean deleteTeacher(int user_id){
        boolean f = false;
        try{
            //jdbc code...
            Connection con = DB.creatDB();
//            SELECT * FROM `student_courses`;
//
//            DELETE from student where student_id = 23;
//            ALTER TABLE student_courses DROP CONSTRAINT FK_Stu_StuCrs_Cascade_Delete;
//
//            ALTER TABLE student_courses
//            ADD CONSTRAINT FK_Stu_StuCrs_Cascade_Delete
//            FOREIGN KEY(student_id) REFERENCES student(student_id) on DELETE CASCADE
            String q = "delete from student where student_id="+"'"+user_id+"'";
            //PreparedStatement
            PreparedStatement pstm = con.prepareStatement(q);
            // set the values of parameter
//            pstm.setInt(1, user_id);

            //execute...
            pstm.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllTeachers() {
        boolean f = false;
        try{
            //jdbc code...
            Connection con = DB.creatDB();
            String q = "select * from student;";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String email = set.getString(3);

                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Email: "+email);
                System.out.println("++++++++++++++++++++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
//        return f;
    }

    public static boolean updateTeacher(int user_id) {
        boolean f = false;
        try{
            Scanner scan = new Scanner(System.in);
            String new_name = null;
            String new_email = null;
            //jdbc code...
            Connection con = DB.creatDB();
            // set the values of parameter
            System.out.println("Do you want to update your name?");
            System.out.println("Enter 1 for yes and 0 for no");
            int update_input = scan.nextInt();
            if (update_input==1){
                Scanner scan2 = new Scanner(System.in);
                System.out.println("Enter new name");
                new_name = scan2.nextLine();
            }

            System.out.println("Do you want to update your email?");
            System.out.println("Enter 1 for yes and 0 for no");
            int update_input1 = scan.nextInt();
            if (update_input1==1){
                Scanner scan3 = new Scanner(System.in);
                System.out.println("Enter new email");
                new_email = scan3.nextLine();
//                System.out.println("Email updates successfully");
            }
//            pstm.setInt(1, user_id);
            String q = "UPDATE student SET  name="+"'"+new_name+"'"+", email="+"'"+new_email+"'"+" WHERE student_id="+user_id;
            //PreparedStetement
            PreparedStatement pstm = con.prepareStatement(q);

            //execute...
            pstm.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

}
