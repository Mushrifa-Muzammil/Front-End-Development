/**
 * Employee Class - Parent Class
 * This is the base class for all employee types
 * Demonstrates inheritance and code reusability
 */
public class Employee {
    
    // ===== FIELDS (Attributes) =====
    protected String name;  // Employee name
    protected int id;       // Employee ID
    
    // ===== CONSTRUCTORS =====
    // Default Constructor
    public Employee() {
        name = "Unknown";
        id = 0;
        System.out.println("Employee Default Constructor Called!");
    }
    
    // Parameterized Constructor
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.println("Employee Parameterized Constructor Called!");
    }
    
    // ===== METHOD TO DISPLAY EMPLOYEE INFO =====
    public void displayInfo() {
        System.out.println("==============================");
        System.out.println("   EMPLOYEE INFORMATION");
        System.out.println("==============================");
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("==============================");
    }
}