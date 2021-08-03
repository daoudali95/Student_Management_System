package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static Connection con;
    public static Connection creatDB(){
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //creating connection
            String user = "root";
            String password = "111";
            String url = "jdbc:mysql://localhost:3306/schoolsystem";
            con = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
