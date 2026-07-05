import java.util.Scanner;

// ============================================
// 1. EMPLOYEE CLASS - PARENT CLASS
// ============================================
class Employee {
    
    protected String name;
    protected int id;
    
    public Employee() {
        name = "Unknown";
        id = 0;
        System.out.println("Employee Default Constructor Called!");
    }
    
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.println("Employee Parameterized Constructor Called!");
    }
    
    public void displayInfo() {
        System.out.println("==============================");
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("==============================");
    }
}

// ============================================
// 2. FULL-TIME EMPLOYEE CLASS - CHILD CLASS 1
// ============================================
class FullTimeEmployee extends Employee {
    
    private double monthlySalary;
    
    public FullTimeEmployee() {
        super();
        monthlySalary = 0.0;
        System.out.println("FullTimeEmployee Default Constructor Called!");
    }
    
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
        System.out.println("FullTimeEmployee Parameterized Constructor Called!");
    }
    
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
    
    public double getMonthlySalary() {
        return monthlySalary;
    }
}

// ============================================
// 3. PART-TIME EMPLOYEE CLASS - CHILD CLASS 2
// ============================================
class PartTimeEmployee extends Employee {
    
    private double hoursWorked;
    private double hourlyRate;
    
    public PartTimeEmployee() {
        super();
        hoursWorked = 0.0;
        hourlyRate = 0.0;
        System.out.println("PartTimeEmployee Default Constructor Called!");
    }
    
    public PartTimeEmployee(String name, int id, double hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        System.out.println("PartTimeEmployee Parameterized Constructor Called!");
    }
    
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
    
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
}

// ============================================
// 4. MAIN CLASS
// ============================================
public class EmployeeProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("========================================\n");
        
        // 1. Full-Time Employee
        System.out.println("--- Full-Time Employee Details ---");
        System.out.print("Name: ");
        String ftName = input.nextLine();
        System.out.print("ID: ");
        int ftId = input.nextInt();
        System.out.print("Monthly Salary: ₹");
        double monthlySalary = input.nextDouble();
        input.nextLine();
        
        FullTimeEmployee ftEmployee = new FullTimeEmployee(ftName, ftId, monthlySalary);
        ftEmployee.calculateSalary();
        System.out.println();
        
        // 2. Part-Time Employee
        System.out.println("--- Part-Time Employee Details ---");
        System.out.print("Name: ");
        String ptName = input.nextLine();
        System.out.print("ID: ");
        int ptId = input.nextInt();
        System.out.print("Hours Worked: ");
        double hoursWorked = input.nextDouble();
        System.out.print("Hourly Rate: ₹");
        double hourlyRate = input.nextDouble();
        
        PartTimeEmployee ptEmployee = new PartTimeEmployee(ptName, ptId, hoursWorked, hourlyRate);
        ptEmployee.calculateSalary();
        System.out.println();
        
        // 3. Parent Employee
        Employee emp = new Employee("Ravi Kumar", 101);
        emp.displayInfo();
        System.out.println();
        
        // 4. Summary
        System.out.println("=== ALL EMPLOYEES SUMMARY ===");
        emp.displayInfo();
        ftEmployee.displayInfo();
        ptEmployee.displayInfo();
        
        input.close();
    }
}