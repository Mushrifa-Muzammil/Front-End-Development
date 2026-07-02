import java.util.Scanner;

/**
 * STUDENT CLASS - With 3 Constructors
 */
class Student {
    // ===== ATTRIBUTES =====
    private int studentId;
    private String studentName;
    private String course;
    
    // ===== 1. DEFAULT CONSTRUCTOR =====
    public Student() {
        studentId = 0;
        studentName = "Unknown";
        course = "Not Assigned";
        System.out.println("Default Constructor Called!");
    }
    
    // ===== 2. PARAMETERIZED CONSTRUCTOR =====
    public Student(int studentId, String studentName, String course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        System.out.println("Parameterized Constructor Called!");
    }
    
    // ===== 3. COPY CONSTRUCTOR =====
    public Student(Student other) {
        this.studentId = other.studentId;
        this.studentName = other.studentName;
        this.course = other.course;
        System.out.println("Copy Constructor Called!");
    }
    
    // ===== DISPLAY METHOD =====
    public void displayDetails() {
        System.out.println("==============================");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Course: " + course);
        System.out.println("==============================");
    }
}

/**
 * MAIN CLASS - To Test Student Class
 */
public class StudentProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===\n");
        
        // ===== 1. DEFAULT CONSTRUCTOR =====
        System.out.println("1. Student using Default Constructor:");
        Student student1 = new Student();
        student1.displayDetails();
        System.out.println();
        
        // ===== 2. PARAMETERIZED CONSTRUCTOR (User Input) =====
        System.out.println("2. Student using Parameterized Constructor:");
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = input.nextLine();
        System.out.print("Enter Course: ");
        String course = input.nextLine();
        
        Student student2 = new Student(id, name, course);
        student2.displayDetails();
        System.out.println();
        
        // ===== 3. COPY CONSTRUCTOR =====
        System.out.println("3. Student using Copy Constructor:");
        Student student3 = new Student(student2);
        student3.displayDetails();
        System.out.println();
        
        // ===== SUMMARY =====
        System.out.println("=== ALL STUDENTS SUMMARY ===\n");
        System.out.println("Student 1 (Default):");
        student1.displayDetails();
        
        System.out.println("\nStudent 2 (Parameterized):");
        student2.displayDetails();
        
        System.out.println("\nStudent 3 (Copy of Student 2):");
        student3.displayDetails();
        
        input.close();
    }
}