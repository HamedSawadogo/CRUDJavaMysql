package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection connection=null;
    private  DatabaseConnection(){
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","l0G9IjqGzqZtZSOx");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public  static Connection getInstance(){
         if(connection==null){
             new DatabaseConnection();
         }
         return  connection;
    }
}
