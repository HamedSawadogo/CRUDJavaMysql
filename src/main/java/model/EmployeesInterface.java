package model;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeesInterface {
    public  void addEmployee(Employee employee) throws SQLException;
    public  void deleteEmployee(int id) throws SQLException;
    public  void updateEmployee(Employee employee,int id) throws SQLException;
    public List<Employee> getlistOfEmployees() throws SQLException;
}
