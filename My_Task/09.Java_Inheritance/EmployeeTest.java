/**
 * EmployeeTest Class - Tests Inheritance
 * Creates objects of Employee, FullTimeEmployee, and PartTimeEmployee
 * Demonstrates inheritance and polymorphism
 */
public class EmployeeTest {
    public static void main(String[] args) {
        
        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===\n");
        
        // ===== 1. CREATE PARENT CLASS OBJECT (Employee) =====
        System.out.println("1. Creating Employee (Parent Class):");
        Employee emp = new Employee("Ravi Kumar", 101);
        emp.displayInfo();
        System.out.println();
        
        // ===== 2. CREATE FULL-TIME EMPLOYEE =====
        System.out.println("2. Creating Full-Time Employee:");
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee("Rajesh", 201, 50000);
        fullTimeEmp.displayInfo();      // Inherited method
        fullTimeEmp.calculateSalary();  // Child class method
        System.out.println();
        
        // ===== 3. CREATE PART-TIME EMPLOYEE =====
        System.out.println("3. Creating Part-Time Employee:");
        PartTimeEmployee partTimeEmp = new PartTimeEmployee("Priya", 301, 20, 500);
        partTimeEmp.displayInfo();      // Inherited method
        partTimeEmp.calculateSalary();  // Child class method
        System.out.println();
        
        // ===== 4. SUMMARY =====
        System.out.println("=== ALL EMPLOYEES SUMMARY ===\n");
        
        System.out.println("Employee (Parent):");
        emp.displayInfo();
        
        System.out.println("\nFull-Time Employee:");
        fullTimeEmp.displayInfo();
        System.out.println("Monthly Salary: ₹" + fullTimeEmp.getMonthlySalary());
        
        System.out.println("\nPart-Time Employee:");
        partTimeEmp.displayInfo();
        System.out.println("Hours: " + partTimeEmp.getHoursWorked() + 
                          " hrs, Rate: ₹" + partTimeEmp.getHourlyRate() + "/hr");
    }
}