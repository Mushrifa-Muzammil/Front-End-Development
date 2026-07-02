/**
 * Student Class - Demonstrates Constructors in Java
 */
public class Student {
    
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
    // ✅ CORRECT: 'Student' (Capital S) - matches class name
    public Student(int studentId, String studentName, String course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        System.out.println("Parameterized Constructor Called!");
    }
    
    // ===== 3. COPY CONSTRUCTOR =====
    // ✅ CORRECT: 'Student' (Capital S) - matches class name
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