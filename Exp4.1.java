Experiment 4.1: Employee Management System

code :

import java.util.ArrayList;

class Employee 
{
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) 
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

class EmployeeManagementSystem 
{
    private ArrayList<Employee> employees = new ArrayList<>();

    void addEmployee(int id, String name, double salary) 
    {
        for (Employee e : employees) 
        {
            if (e.id == id) 
            {
                System.out.println("Error: Employee with ID " + id + " already exists.");
                return;
            }
        }
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added: ID=" + id + ", Name=" + name + ", Salary=" + salary);
    }

    void updateEmployeeSalary(int id, double newSalary) 
    {
        for (Employee e : employees) 
        {
            if (e.id == id) 
            {
                e.salary = newSalary;
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    void removeEmployee(int id) 
    {
        for (int i = 0; i < employees.size(); i++) 
        {
            if (employees.get(i).id == id) 
            {
                employees.remove(i);
                System.out.println("Employee ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    void searchEmployee(int id) 
    {
        for (Employee e : employees) 
        {
            if (e.id == id) 
            {
                System.out.println("Employee Found: ID=" + e.id + ", Name=" + e.name + ", Salary=" + e.salary);
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }
    void displayEmployees() 
    {
        if (employees.isEmpty()) 
        {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println("ID=" + e.id + ", Name=" + e.name + ", Salary=" + e.salary);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.displayEmployees();

        ems.addEmployee(101, "Anish", 50000);
        ems.addEmployee(102, "Bobby", 60000);


        ems.updateEmployeeSalary(101, 55000);

        ems.searchEmployee(102);


        ems.removeEmployee(101);


        ems.displayEmployees();

        ems.addEmployee(101, "Charlie", 70000);
    }
}




Test Cases

Test Case 1: Adding Employees (No Employees Initially)
Display Employees
Expected Output:
No employees found.
  
Test Case 2: Add Employees
Input:
Add Employee (ID=101, Name="Anish", Salary=50000)
Add Employee (ID=102, Name="Bobby", Salary=60000)
Expected Output:
Employee Added: ID=101, Name=Anish, Salary=50000
Employee Added: ID=102, Name=Bobby, Salary=60000

Test Case 3: Update Employee Salary
Input:
Update Employee (ID=101, New Salary=55000)
Expected Output:
Employee ID 101 updated successfully.

Test Case 4: Search Employee by ID
Input:
Search Employee by ID=102
Expected Output:
Employee Found: ID=102, Name=Bobby, Salary=60000

Test Case 5: Remove Employee
Input:
Remove Employee (ID=101)
Expected Output:
Employee ID 101 removed successfully.

Test Case 6: Display All Employees
Input:
Display Employees
Expected Output:
ID: 102, Name: Bobby, Salary: 60000

Test Case 7: Adding Duplicate Employee ID
Input:
Add Employee (ID=101, Name="Charlie", Salary=70000)
Expected Output:
Error: Employee with ID 101 already exists.


