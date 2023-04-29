package controllers;

import model.DatabaseConnection;
import model.Employee;
import model.EmployeesInterface;
import vews.EmployeeVew;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeController implements EmployeesInterface {
    private  Employee employee;
    private Connection connection= DatabaseConnection.getInstance();
    private EmployeeVew employeeVew;
    private int choice;

    public  EmployeeController(EmployeeVew employeeVew){
        this.employeeVew=employeeVew;
        this.employee=new Employee();
        this.employeeVew.setEmployeeController(this);
    }
    public  void scanEmployee(){
        this.employeeVew.promptUser();
    }
    public  void displayEmployees(){
        this.employeeVew.displaysEmployees();
   }
    public  void runn(){
        Scanner scanner=new Scanner(System.in);
        this.employeeVew.menu();
        this.choice=scanner.nextInt();
            switch (choice){
                case 1:
                    this.employeeVew.promptUser();
                    this.runn();
                    break;
                case 2:
                    this.employeeVew.displaysEmployees();
                    this.runn();
                    break;
                case 3:
                    this.employeeVew.deleteEmployee();
                    this.runn();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.print("choix invalide");
                    break;
            }
        }
    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String query="INSERT INTO employee(email,first_name,last_name) VALUES(?,?,?)";
            PreparedStatement statement=this.connection.prepareStatement(query);
            statement.setString(1,employee.getEmail());
            statement.setString(2,employee.getFirstName());
            statement.setString(3,employee.getLastName());
            statement.executeUpdate();

    }
    @Override
    public void deleteEmployee(int id) throws SQLException {
        String query="DELETE FROM employee WHERE id="+id;
        PreparedStatement statement=this.connection.prepareStatement(query);
        statement.executeUpdate();
    }
    @Override
    public void updateEmployee(Employee employee, int id) throws SQLException {
        String sql="UPDATE employee SET first_name=?,last_name=?,email=? WHERE id=?";
        PreparedStatement statement=this.connection.prepareStatement(sql);
        statement.setString(1,employee.getFirstName());
        statement.setString(2,employee.getLastName());
        statement.setString(3,employee.getEmail());
        statement.setInt(4,id);
        statement.executeUpdate();
    }
    @Override
    public List<Employee> getlistOfEmployees() throws SQLException {
        String query="SELECT * FROM employee";
        List<Employee>listOfEmployees=new ArrayList<>();
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

    }
}
