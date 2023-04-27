package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner scanner=new Scanner(System.in);
        Employee employee=new Employee();
        employee.deleteEmployee(4);
        /**System.out.println("entrer le nom de l'employee: ");
        String name=scanner.nextLine();
        System.out.println("entrer le prenom de l'employee: ");
        String last=scanner.nextLine();
        System.out.println("entrer l'adresee email : ");
        String email=scanner.nextLine();
        Employee employeeAded=new Employee(name,last,email);
        employee.addEmployee(employeeAded);**/

        for (Employee empl:employee.getlistOfEmployees()) {
            empl.displayEmployee();
            System.out.println("----------------------------");
        }
    }
}