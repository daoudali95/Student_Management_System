package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Student_coursesDB {
    public static boolean insertCoursestoDB(Student st1, int id){
        boolean f = false;
        //jdbc code...
        try {
            Connection con = DB.creatDB();
            //query
            String q = "insert into student_courses(course_name,student_id) values(?,?)";
            //prepared statement...
            PreparedStatement pstm = con.prepareStatement(q);
            for (String selected_courses:st1.getCourses()
                 ) {
                pstm.setString(1,selected_courses);
                pstm.setInt(2,id);
                pstm.executeUpdate();
            }
            //Execution...
            f = true;
        }catch (Exception e){
            //printing exceptions
            e.printStackTrace();
        }
        return f;
    }
}
