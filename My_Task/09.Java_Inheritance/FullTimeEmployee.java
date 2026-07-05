/**
 * FullTimeEmployee Class - Child Class of Employee
 * Represents a full-time employee with monthly salary
 * Demonstrates inheritance by extending Employee class
 */
public class FullTimeEmployee extends Employee {
    
    // ===== ADDITIONAL FIELD =====
    private double monthlySalary;  // Monthly salary for full-time employee
    
    // ===== CONSTRUCTORS =====
    // Default Constructor
    public FullTimeEmployee() {
        super();  // Calls parent default constructor
        monthlySalary = 0.0;
        System.out.println("FullTimeEmployee Default Constructor Called!");
    }
    
    // Parameterized Constructor
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);  // Calls parent parameterized constructor
        this.monthlySalary = monthlySalary;
        System.out.println("FullTimeEmployee Parameterized Constructor Called!");
    }
    
    // ===== METHOD TO CALCULATE SALARY =====
    public void calculateSalary() {
        System.out.println("==============================");
        System.out.println("   FULL-TIME EMPLOYEE SALARY");
        System.out.println("==============================");
        System.out.println("Employee: " + name);
        System.out.println("ID: " + id);
        System.out.println("Monthly Salary: ₹" + monthlySalary);
        System.out.println("Yearly Salary: ₹" + (monthlySalary * 12));
        System.out.println("==============================");
    }
    
    // ===== GETTER AND SETTER =====
    public double getMonthlySalary() {
        return monthlySalary;
    }
    
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}