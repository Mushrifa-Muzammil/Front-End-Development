/**
 * Student Class - Extends Person, Implements Borrowable
 * Demonstrates Inheritance and Interface
 */
public class Student extends Person implements Borrowable {
    
    private String studentId;
    private String department;
    private int booksBorrowed;
    
    public Student(int id, String name, String email, String studentId, String department) {
        super(id, name, email);
        this.studentId = studentId;
        this.department = department;
        this.booksBorrowed = 0;
        System.out.println("🎓 Student Created: " + name);
    }
    
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public int getBooksBorrowed() { return booksBorrowed; }
    
    public void displayStudentInfo() {
        System.out.println("======================================");
        System.out.println("   STUDENT DETAILS");
        System.out.println("======================================");
        displayPersonInfo();
        System.out.println("Student ID     : " + studentId);
        System.out.println("Department     : " + department);
        System.out.println("Books Borrowed : " + booksBorrowed);
        System.out.println("======================================");
    }
    
    @Override
    public void borrowItem() {
        booksBorrowed++;
        System.out.println("📖 Student " + name + " borrowed a book. Total: " + booksBorrowed);
    }
    
    @Override
    public void returnItem() {
        if (booksBorrowed > 0) {
            booksBorrowed--;
            System.out.println("📖 Student " + name + " returned a book. Total: " + booksBorrowed);
        } else {
            System.out.println("❌ Student " + name + " has no books to return!");
        }
    }
}