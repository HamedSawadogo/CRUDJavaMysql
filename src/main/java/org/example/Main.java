package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args)  {
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","l0G9IjqGzqZtZSOx");
            Statement statement=connection.createStatement();

            ResultSet resultSet=statement.executeQuery("SELECT * FROM employee");
            ResultSetMetaData metaData=resultSet.getMetaData();

            System.out.println("----------------liste des employees------------------------");
            while (resultSet.next()){
                  System.out.println("Nom de l'employee: "+resultSet.getString("first_name"));
                  System.out.println("prenom de l'employee: "+resultSet.getString("first_name"));
                  System.out.println("Adresse mail: "+resultSet.getString("email"));
                  System.out.println("--------------------------------------------------------");

            }
            resultSet.close();
            statement.close();

        }catch (SQLException e){
             System.out.println(e);
        }
    }
}