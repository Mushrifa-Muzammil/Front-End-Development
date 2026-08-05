import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// ==========================================
// TASK 01: STUDENT CLASS
// ==========================================
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Student ID: " + id + " | Name: " + name;
    }
}

// ==========================================
// TASK 02: EMPLOYEE CLASS
// ==========================================
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee ID: " + id + " | Name: " + name + " | Salary: $" + salary;
    }
}

// ==========================================
// TASK 03: BOOK CLASS
// ==========================================
class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "Book ID: " + id + " | Title: '" + title + "' | Author: " + author;
    }
}

// ==========================================
// MAIN CLASS: RUNNING ALL 3 TASKS
// ==========================================
public class OptionalClassDemo {

    // -------- DATA LISTS FOR EACH TASK --------
    private static List<Student> studentList = new ArrayList<>();
    private static List<Employee> employeeList = new ArrayList<>();
    private static List<Book> bookList = new ArrayList<>();

    // Static block to pre-fill data for testing
    static {
        // Student Data
        studentList.add(new Student(101, "Arun"));
        studentList.add(new Student(102, "Bhavya"));
        studentList.add(new Student(103, "Charles"));

        // Employee Data
        employeeList.add(new Employee(1, "Divya", 55000.0));
        employeeList.add(new Employee(2, "Ezhil", 72000.0));
        employeeList.add(new Employee(3, "Farhan", 48000.0));

        // Book Data
        bookList.add(new Book(1, "Java Complete Reference", "Herbert Schildt"));
        bookList.add(new Book(2, "Clean Code", "Robert C. Martin"));
        bookList.add(new Book(3, "The Alchemist", "Paulo Coelho"));
    }

    // ==========================================
    // TASK 01 METHOD: findStudentById (returns Optional<Student>)
    // ==========================================
    public static Optional<Student> findStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return Optional.of(s); // Wrap found student in Optional
            }
        }
        return Optional.empty(); // Return empty Optional if not found
    }

    // ==========================================
    // TASK 02 METHOD: findEmployee (returns Optional<Employee>)
    // ==========================================
    public static Optional<Employee> findEmployee(int id) {
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

    // ==========================================
    // TASK 03 METHOD: findBookByTitle (returns Optional<Book>)
    // ==========================================
    public static Optional<Book> findBookByTitle(String title) {
        for (Book b : bookList) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }

    // ==========================================
    // MAIN METHOD - EXECUTES ALL 3 TASKS
    // ==========================================
    public static void main(String[] args) {
        System.out.println("========== JAVA OPTIONAL CLASS DEMONSTRATION ==========\n");

        // ----------------- TASK 01: STUDENT SEARCH (Using isPresent() & ifPresent()) -----------------
        System.out.println("--- TASK 01: Student Search ---");
        int searchStudentId = 102;
        Optional<Student> studentOpt = findStudentById(searchStudentId);

        // 1. Using isPresent() to check and print (Traditional way)
        if (studentOpt.isPresent()) {
            System.out.println("✅ Found: " + studentOpt.get().getName());
        } else {
            System.out.println("❌ Student not found");
        }

        // 2. Using ifPresent() (Modern Optional way - prints details directly)
        System.out.print("   (Using ifPresent() method) -> ");
        studentOpt.ifPresent(s -> System.out.println("Found: " + s.toString()));
        
        // Test a non-existent student
        Optional<Student> notFoundOpt = findStudentById(999);
        if (notFoundOpt.isPresent()) {
            System.out.println("✅ Found: " + notFoundOpt.get().getName());
        } else {
            System.out.println("❌ Student not found (Test with ID 999)");
        }
        System.out.println();

        // ----------------- TASK 02: EMPLOYEE LOOKUP (Using orElse()) -----------------
        System.out.println("--- TASK 02: Employee Lookup (Using orElse()) ---");
        int searchEmpId = 2;
        Optional<Employee> empOpt = findEmployee(searchEmpId);

        // Try to get employee, if not found, use default employee via orElse()
        Employee foundEmp = empOpt.orElse(new Employee(0, "Default Employee", 0.0));
        System.out.println("✅ Employee Found (orElse result): " + foundEmp);

        // Test with non-existent ID to demonstrate orElse() default value
        int invalidEmpId = 99;
        Employee notFoundEmp = findEmployee(invalidEmpId).orElse(new Employee(0, "DEFAULT EMPLOYEE", 0.0));
        System.out.println("⚠️  Non-existent ID test (orElse triggered): " + notFoundEmp);
        System.out.println();

        // ----------------- TASK 03: BOOK LIBRARY (Using ifPresent()) -----------------
        System.out.println("--- TASK 03: Book Library (Using ifPresent()) ---");
        String searchBookTitle = "Clean Code";
        Optional<Book> bookOpt = findBookByTitle(searchBookTitle);

        // ifPresent() runs the lambda ONLY if the book exists
        System.out.print("Searching for '" + searchBookTitle + "' -> ");
        bookOpt.ifPresent(book -> System.out.println("✅ Found: " + book));

        // Test a non-existent book
        String invalidBookTitle = "Harry Potter";
        System.out.print("Searching for '" + invalidBookTitle + "' -> ");
        Optional<Book> notFoundBook = findBookByTitle(invalidBookTitle);
        notFoundBook.ifPresentOrElse(
            book -> System.out.println("✅ Found: " + book),
            () -> System.out.println("❌ Book not found! (Using ifPresentOrElse)")
        );
        
        System.out.println("\n========== OPTIONAL DEMONSTRATION COMPLETE ==========");
    }
}