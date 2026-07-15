/**
 * StudentResultGenerator.java
 * Task 03 - Student Result Generator
 * Demonstrates: multiple threads, synchronized method, isAlive()
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Student {
    private String name;
    private int id;
    private int marks;
    private String grade;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.marks = 0;
        this.grade = "Not Calculated";
    }
    
    public String getName() { return name; }
    public int getId() { return id; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }
    
    public void setMarks(int marks) { this.marks = marks; }
    public void setGrade(String grade) { this.grade = grade; }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", marks=" + marks +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class ResultReport {
    private List<String> reportEntries = new ArrayList<>();
    private int totalStudents = 0;
    private double totalMarks = 0;
    
    // Synchronized method to write results to shared report
    public synchronized void addResult(Student student) {
        String entry = "Student: " + student.getName() + 
                      " (ID: " + student.getId() + ")" +
                      " | Marks: " + student.getMarks() +
                      " | Grade: " + student.getGrade();
        
        reportEntries.add(entry);
        totalStudents++;
        totalMarks += student.getMarks();
        
        System.out.println("Result added: " + entry);
        
        // Simulate writing to report
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Result writing interrupted");
        }
    }
    
    public synchronized void displayReport() {
        System.out.println("\n=== STUDENT RESULT REPORT ===");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Average Marks: " + (totalStudents > 0 ? 
                          String.format("%.2f", totalMarks / totalStudents) : "0"));
        System.out.println("\nIndividual Results:");
        for (String entry : reportEntries) {
            System.out.println(entry);
        }
        System.out.println("=============================\n");
    }
}

class StudentResultCalculator extends Thread {
    private Student student;
    private ResultReport report;
    private Random random = new Random();
    
    public StudentResultCalculator(Student student, ResultReport report) {
        super("Calculator-" + student.getName());
        this.student = student;
        this.report = report;
    }
    
    private String calculateGrade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }
    
    @Override
    public void run() {
        System.out.println("Thread " + getName() + " started. isAlive: " + isAlive());
        
        // Simulate calculation
        try {
            // Random marks between 0-100
            int marks = random.nextInt(101);
            
            // Simulate processing time
            Thread.sleep(500 + random.nextInt(500));
            
            // Calculate grade
            String grade = calculateGrade(marks);
            
            // Update student with marks and grade
            student.setMarks(marks);
            student.setGrade(grade);
            
            // Add to report using synchronized method
            report.addResult(student);
            
            System.out.println("Thread " + getName() + " completed. isAlive: " + isAlive());
            
        } catch (InterruptedException e) {
            System.out.println("Thread " + getName() + " interrupted");
        }
    }
}

public class StudentResultGenerator {
    public static void main(String[] args) {
        System.out.println("=== Student Result Generator ===");
        
        // Create students
        Student[] students = {
            new Student("Alice Johnson", 101),
            new Student("Bob Smith", 102),
            new Student("Charlie Brown", 103),
            new Student("Diana Prince", 104),
            new Student("Eve Wilson", 105),
            new Student("Frank Castle", 106)
        };
        
        // Create shared report
        ResultReport report = new ResultReport();
        
        // Create threads for each student
        List<StudentResultCalculator> threads = new ArrayList<>();
        for (Student student : students) {
            StudentResultCalculator calculator = 
                new StudentResultCalculator(student, report);
            threads.add(calculator);
        }
        
        // Start all threads
        System.out.println("\nStarting result calculation for " + students.length + " students...\n");
        for (StudentResultCalculator thread : threads) {
            thread.start();
        }
        
        // Check thread completion using isAlive()
        boolean allCompleted = false;
        while (!allCompleted) {
            allCompleted = true;
            for (StudentResultCalculator thread : threads) {
                if (thread.isAlive()) {
                    allCompleted = false;
                    System.out.println("Thread " + thread.getName() + 
                                     " is still running...");
                    
                    // Wait a bit before checking again
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.out.println("Main thread interrupted");
                    }
                    break;
                }
            }
        }
        
        // Display final report
        report.displayReport();
        
        System.out.println("All result calculations completed.");
    }
}