package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employee{

    private  int id;
    private String email;
    private  String firstName;
    private  String lastName;
    private Connection connection= DatabaseConnection.getInstance();
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
