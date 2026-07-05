/**
 * Librarian Class - Extends Person
 * Demonstrates Inheritance in Java
 */
public class Librarian extends Person {
    
    private String employeeId;
    private String department;
    private int yearsOfExperience;
    
    public Librarian(int id, String name, String email, String employeeId, String department, int yearsOfExperience) {
        super(id, name, email);
        this.employeeId = employeeId;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
        System.out.println("📚 Librarian Created: " + name);
    }
    
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
    
    public void displayLibrarianInfo() {
        System.out.println("======================================");
        System.out.println("   LIBRARIAN DETAILS");
        System.out.println("======================================");
        displayPersonInfo();
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Department  : " + department);
        System.out.println("Experience  : " + yearsOfExperience + " years");
        System.out.println("======================================");
    }
    
    public void issueBook(Student student, Book book) {
        if (!book.isBorrowed()) {
            book.borrowItem();
            student.borrowItem();
            System.out.println("✅ Book issued to " + student.getName() + " by Librarian " + name);
        } else {
            System.out.println("❌ Book is already borrowed!");
        }
    }
    
    public void receiveBook(Student student, Book book) {
        if (book.isBorrowed()) {
            book.returnItem();
            student.returnItem();
            System.out.println("✅ Book received from " + student.getName() + " by Librarian " + name);
        } else {
            System.out.println("❌ Book was not borrowed!");
        }
    }
}