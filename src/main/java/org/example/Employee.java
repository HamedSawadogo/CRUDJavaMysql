package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employee implements EmployeesInterface{

    private  int id;
    private String email;
    private  String firstName;
    private  String lastName;
    private Connection connection=DatabaseConnection.getInstance();
    public  Employee(){}

    public  Employee(String firstNamename,String lastName,String email){
        this.email=email;
        this.firstName=firstNamename;
        this.lastName=lastName;
    }
    public  Employee(int id,String firstNamename,String lastName,String email){
        this.email=email;
        this.firstName=firstNamename;
        this.lastName=lastName;
        this.id=id;
    }
    public  void displayEmployee(){
        System.out.println("Nom de l'employee: "+this.firstName);
        System.out.println("prenom de l'employee: "+this.lastName);
        System.out.println("Adresse mail: "+this.email);
    }
    @Override
    public void addEmployee(Employee employee) {
        String query="INSERT INTO employee(email,first_name,last_name) VALUES(?,?,?)";
        try {
            PreparedStatement statement=this.connection.prepareStatement(query);
            statement.setString(1,employee.getEmail());
            statement.setString(2,employee.getFirstName());
            statement.setString(3,employee.getLastName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteEmployee(int id) {
      String query="DELETE FROM employee WHERE id="+id;
        try {
            PreparedStatement statement=this.connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(Employee employee, int id) {

    }

    @Override
    public List<Employee> getlistOfEmployees() {
        String query="SELECT * FROM employee";
        List<Employee>listOfEmployees=new ArrayList<>();
        try {
           PreparedStatement statement=this.connection.prepareStatement(query);
           ResultSet resultSet=statement.executeQuery();
           while (resultSet.next()){
               Employee employee=new Employee();
               employee.setFirstName(resultSet.getString("first_name"));
               employee.setLastName(resultSet.getString("last_name"));
               employee.setEmail(resultSet.getString("email"));
               listOfEmployees.add(employee);
           }
           statement.close();
           resultSet.close();
           return  listOfEmployees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //getters and setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
