package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Teacher_CoursesDB {
    public static boolean insertTCoursestoDB(Teacher t, int id){
        boolean f = false;
        //jdbc code...
        try {
            Connection con = DB.creatDB();
            //query
            String q = "insert into teacher_courses(course_name,teacher_id) values(?,?)";
            //prepared statement...
            PreparedStatement pstm = con.prepareStatement(q);
            for (String selected_courses:t.getCourses()
            ) {
                pstm.setString(1,selected_courses);
                pstm.setInt(2, id);
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