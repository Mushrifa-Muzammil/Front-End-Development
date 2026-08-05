import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// ---------------------- CLASS: EMPLOYEE ----------------------
class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(int id, String name, int age, double salary, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Name: %-10s | Age: %-3d | Salary: ₹%.2f | Dept: %-8s", 
                             id, name, age, salary, department);
    }
}

// ---------------------- MAIN CLASS ----------------------
public class EmployeeStreamDemo {
    public static void main(String[] args) {
        // Create a list of employees for testing
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Arun", 25, 45000.0, "HR"));
        employees.add(new Employee(102, "Bhavya", 32, 75000.0, "IT"));
        employees.add(new Employee(103, "Charles", 28, 55000.0, "Finance"));
        employees.add(new Employee(104, "Divya", 35, 88000.0, "IT"));
        employees.add(new Employee(105, "Ezhil", 40, 62000.0, "HR"));
        employees.add(new Employee(106, "Farhan", 29, 95000.0, "IT"));
        employees.add(new Employee(107, "Gita", 45, 50000.0, "Finance"));
        employees.add(new Employee(108, "Hari", 31, 120000.0, "IT"));

        System.out.println("========== EMPLOYEE DATA PROCESSING ==========\n");
        System.out.println("--- Full Employee List ---");
        employees.forEach(System.out::println);
        System.out.println("\n----------------------------------------------------\n");

        // ---------------------- TASK 01: Salary > 60,000 (Using Predicate) ----------------------
        System.out.println("--- TASK 01: Employees with Salary > ₹60,000 ---");
        Predicate<Employee> highSalaryPredicate = emp -> emp.getSalary() > 60000;
        employees.stream()
                 .filter(highSalaryPredicate)
                 .forEach(System.out::println);
        System.out.println();

        // ---------------------- TASK 02: IT Department AND Age > 30 ----------------------
        System.out.println("--- TASK 02: IT Dept Employees Older than 30 ---");
        employees.stream()
                 .filter(emp -> emp.getDepartment().equalsIgnoreCase("IT") && emp.getAge() > 30)
                 .forEach(System.out::println);
        System.out.println();

        // ---------------------- TASK 03: Count Employees with Age > 30 ----------------------
        System.out.println("--- TASK 03: Count of Employees with Age > 30 ---");
        long countAgeAbove30 = employees.stream()
                                        .filter(emp -> emp.getAge() > 30)
                                        .count();
        System.out.println("Count: " + countAgeAbove30);
        System.out.println();

        // ---------------------- TASK 04: Highest Paid Employee ----------------------
        System.out.println("--- TASK 04: Highest Paid Employee ---");
        Optional<Employee> highestPaid = employees.stream()
                                                  .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaid.ifPresent(emp -> System.out.println("Highest Paid: " + emp));
        System.out.println();

        // ---------------------- TASK 05: Employee Names in Uppercase ----------------------
        System.out.println("--- TASK 05: Employee Names in Uppercase ---");
        employees.stream()
                 .map(emp -> emp.getName().toUpperCase())
                 .forEach(name -> System.out.print(name + " "));
        System.out.println("\n");

        // ---------------------- TASK 06: Average Salary ----------------------
        System.out.println("--- TASK 06: Average Salary ---");
        double averageSalary = employees.stream()
                                        .mapToDouble(Employee::getSalary)
                                        .average()
                                        .orElse(0.0);
        System.out.printf("Average Salary: ₹%.2f\n", averageSalary);
        System.out.println();

        // ---------------------- TASK 07: Group Employees by Department ----------------------
        System.out.println("--- TASK 07: Group Employees by Department ---");
        Map<String, List<Employee>> groupedByDept = employees.stream()
                                                             .collect(Collectors.groupingBy(Employee::getDepartment));
        
        groupedByDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(emp -> System.out.println("  -> " + emp));
        });
        System.out.println();

        // ---------------------- TASK 08: Sort by Salary (Descending) ----------------------
        System.out.println("--- TASK 08: Employees Sorted by Salary (Descending) ---");
        employees.stream()
                 .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                 .forEach(System.out::println);
        System.out.println();

        // ---------------------- TASK 09: First Employee with Salary > ₹80,000 ----------------------
        System.out.println("--- TASK 09: First Employee with Salary > ₹80,000 ---");
        Optional<Employee> firstHighSalary = employees.stream()
                                                      .filter(emp -> emp.getSalary() > 80000)
                                                      .findFirst();
        firstHighSalary.ifPresentOrElse(
            emp -> System.out.println("Found: " + emp),
            () -> System.out.println("No employee found with salary > ₹80,000")
        );
        System.out.println();

        // ---------------------- TASK 10: Second Highest Salary ----------------------
        System.out.println("--- TASK 10: Second Highest Salary ---");
        Optional<Double> secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct() // Remove duplicates to get unique salaries
                .sorted(Comparator.reverseOrder())
                .skip(1)    // Skip the highest salary
                .findFirst();

        secondHighestSalary.ifPresentOrElse(
            salary -> System.out.printf("Second Highest Salary: ₹%.2f\n", salary),
            () -> System.out.println("Not enough employees to find second highest salary.")
        );

        System.out.println("\n========== PROCESSING COMPLETE ==========");
    }
}