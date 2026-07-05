/**
 * PartTimeEmployee Class - Child Class of Employee
 * Represents a part-time employee with hourly rate and hours worked
 * Demonstrates inheritance by extending Employee class
 */
public class PartTimeEmployee extends Employee {
    
    // ===== ADDITIONAL FIELDS =====
    private double hoursWorked;  // Number of hours worked
    private double hourlyRate;   // Rate per hour
    
    // ===== CONSTRUCTORS =====
    // Default Constructor
    public PartTimeEmployee() {
        super();  // Calls parent default constructor
        hoursWorked = 0.0;
        hourlyRate = 0.0;
        System.out.println("PartTimeEmployee Default Constructor Called!");
    }
    
    // Parameterized Constructor
    public PartTimeEmployee(String name, int id, double hoursWorked, double hourlyRate) {
        super(name, id);  // Calls parent parameterized constructor
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        System.out.println("PartTimeEmployee Parameterized Constructor Called!");
    }
    
    // ===== METHOD TO CALCULATE SALARY =====
    // Salary = hoursWorked × hourlyRate
    public void calculateSalary() {
        double salary = hoursWorked * hourlyRate;
        System.out.println("==============================");
        System.out.println("   PART-TIME EMPLOYEE SALARY");
        System.out.println("==============================");
        System.out.println("Employee: " + name);
        System.out.println("ID: " + id);
        System.out.println("Hours Worked: " + hoursWorked + " hours");
        System.out.println("Hourly Rate: ₹" + hourlyRate);
        System.out.println("Total Salary: ₹" + salary);
        System.out.println("==============================");
    }
    
    // ===== GETTER AND SETTER METHODS =====
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}