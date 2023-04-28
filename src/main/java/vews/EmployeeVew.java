package vews;

import controllers.EmployeeController;
import model.Employee;

import javax.swing.plaf.PanelUI;
import java.util.Scanner;

public class EmployeeVew {
    private final Scanner  scanner=new Scanner(System.in);
    private EmployeeController employeeController;

    public  EmployeeVew(){}

    public  void menu(){
        System.out.println("------------GESTION DES EMPLOYEES---------------");
        System.out.println("1: enregistrer un employee   ");
        System.out.println("2: liste des empployees   ");
        System.out.println("3: supprimer un employee   ");
        System.out.println("4: modifier un employee  ");
        System.out.println("5: quitter ");
    }
    public  void promptUser(){
        System.out.print("entrer le nom de l'employee:  ");
        String name=this.scanner.next();
        System.out.print("entrer le prenom de l'employee: ");
        String lastName=this.scanner.next();
        System.out.print("entrer l'adresse mail de l'employee: ");
        String email=this.scanner.next();
        this.employeeController.addEmployee(new Employee(name,lastName,email));
    }
    public void displaysEmployees(){
        for (Employee employee:this.employeeController.getlistOfEmployees()) {
            displayEmployee(employee);
        }
    }
    public  void deleteEmployee(){
        System.out.println("enter le code a supprimer:  ");
        int code=scanner.nextInt();
        employeeController.deleteEmployee(code);
    }
    private   void displayEmployee(Employee employee){
             System.out.println("Nom de l'employee: "+employee.getFirstName());
            System.out.println("prenom de l'employee: "+employee.getLastName());
            System.out.println("Adresse mail: "+employee.getEmail());
            System.out.println("-------------------------------------------------");
    }
    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
