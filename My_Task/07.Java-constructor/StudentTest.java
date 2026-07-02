/**
 * StudentTest Class - Tests all three constructors
 * Creates 3 Student objects and displays their details
 */
public class StudentTest {
    public static void main(String[] args) {
        
        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===\n");
        
        // ===== 1. Creating student using DEFAULT CONSTRUCTOR =====
        System.out.println("1. Creating Student using Default Constructor:");
        Student student1 = new Student();
        student1.displayDetails();
        System.out.println();
        
        // ===== 2. Creating student using PARAMETERIZED CONSTRUCTOR =====
        System.out.println("2. Creating Student using Parameterized Constructor:");
        Student student2 = new Student(101, "Raj Kumar", "Computer Science");
        student2.displayDetails();
        System.out.println();
        
        // ===== 3. Creating student using COPY CONSTRUCTOR =====
        System.out.println("3. Creating Student using Copy Constructor:");
        Student student3 = new Student(student2);
        student3.displayDetails();
        System.out.println();
        
        // ===== SUMMARY OF ALL STUDENTS =====
        System.out.println("=== ALL STUDENTS SUMMARY ===\n");
        
        System.out.println("Student 1 (Default Constructor):");
        student1.displayDetails();
        
        System.out.println("\nStudent 2 (Parameterized Constructor):");
        student2.displayDetails();
        
        System.out.println("\nStudent 3 (Copy Constructor - Copied from Student 2):");
        student3.displayDetails();
    }
}