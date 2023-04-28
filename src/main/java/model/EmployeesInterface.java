package model;

import model.Employee;
import java.util.List;

public interface EmployeesInterface {
    public  void addEmployee(Employee employee);
    public  void deleteEmployee(int id);
    public  void updateEmployee(Employee employee,int id);
    public List<Employee> getlistOfEmployees();
}
