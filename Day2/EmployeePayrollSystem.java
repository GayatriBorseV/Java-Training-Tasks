// Base Class
class Employee {
    private String name;
    private int id;
    private String designation;
    private double basicSalary;

    // Constructor
    public Employee(String name, int id, String designation, double basicSalary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Display Employee Details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: " + basicSalary);
    }

    // Calculate and return the total salary (to be overridden by subclasses)
    public double calculateSalary() {
        return basicSalary;
    }
}

// Subclass for Full-Time Employees
class FullTimeEmployee extends Employee {
    private double hra; // House Rent Allowance
    private double da;  // Dearness Allowance

    // Constructor
    public FullTimeEmployee(String name, int id, String designation, double basicSalary, double hra, double da) {
        super(name, id, designation, basicSalary);
        this.hra = hra;
        this.da = da;
    }

    // Calculate total salary (basic + HRA + DA)
    @Override
    public double calculateSalary() {
        return getBasicSalary() + hra + da;
    }

    // Display Full-Time Employee Details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Display base class details
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println();
    }
}

// Main Class
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        // Create a regular employee
        Employee emp1 = new Employee("Alice", 101, "Developer", 50000);
        emp1.displayDetails();
        System.out.println("Total Salary: " + emp1.calculateSalary());
        System.out.println();

        // Create a full-time employee
        FullTimeEmployee emp2 = new FullTimeEmployee("Bob", 102, "Senior Developer", 60000, 10000, 8000);
        emp2.displayDetails();
    }
}
