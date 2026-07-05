// ============================================
// 1. INTERFACE - BORROWABLE
// ============================================
interface Borrowable {
    void borrowItem();
    void returnItem();
}

// ============================================
// 2. ABSTRACT CLASS - LIBRARYITEM
// ============================================
abstract class LibraryItem {
    public abstract void displayInfo();
}

// ============================================
// 3. CLASS - PERSON
// ============================================
class Person {
    protected int id;
    protected String name;
    protected String email;
    
    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public String getName() { return name; }
    
    public void displayPersonInfo() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}

// ============================================
// 4. CLASS - BOOK
// ============================================
class Book extends LibraryItem implements Borrowable {
    private int bookId;
    private String title;
    private String author;
    private double price;
    private boolean isBorrowed;
    
    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isBorrowed = false;
    }
    
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public boolean isBorrowed() { return isBorrowed; }
    
    public void setBookId(int bookId) { this.bookId = bookId; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(double price) { this.price = price; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }
    
    @Override
    public void displayInfo() {
        System.out.println("======================================");
        System.out.println("   BOOK DETAILS");
        System.out.println("======================================");
        System.out.println("Book ID    : " + bookId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : ₹" + price);
        System.out.println("Status     : " + (isBorrowed ? "Borrowed" : "Available"));
        System.out.println("======================================");
    }
    
    @Override
    public void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("✅ Book '" + title + "' borrowed!");
        } else {
            System.out.println("❌ Book already borrowed!");
        }
    }
    
    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("✅ Book '" + title + "' returned!");
        } else {
            System.out.println("❌ Book not borrowed!");
        }
    }
}

// ============================================
// 5. CLASS - STUDENT
// ============================================
class Student extends Person implements Borrowable {
    private String studentId;
    private String department;
    private int booksBorrowed;
    
    public Student(int id, String name, String email, String studentId, String department) {
        super(id, name, email);
        this.studentId = studentId;
        this.department = department;
        this.booksBorrowed = 0;
    }
    
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
        System.out.println("📖 Student " + name + " borrowed. Total: " + booksBorrowed);
    }
    
    @Override
    public void returnItem() {
        if (booksBorrowed > 0) {
            booksBorrowed--;
            System.out.println("📖 Student " + name + " returned. Total: " + booksBorrowed);
        } else {
            System.out.println("❌ No books to return!");
        }
    }
}

// ============================================
// 6. CLASS - LIBRARIAN
// ============================================
class Librarian extends Person {
    private String employeeId;
    private String department;
    private int yearsOfExperience;
    
    public Librarian(int id, String name, String email, String employeeId, String department, int yearsOfExperience) {
        super(id, name, email);
        this.employeeId = employeeId;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }
    
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
            System.out.println("✅ Book issued to " + student.getName() + " by " + name);
        } else {
            System.out.println("❌ Book already borrowed!");
        }
    }
    
    public void receiveBook(Student student, Book book) {
        if (book.isBorrowed()) {
            book.returnItem();
            student.returnItem();
            System.out.println("✅ Book received from " + student.getName() + " by " + name);
        } else {
            System.out.println("❌ Book not borrowed!");
        }
    }
}

// ============================================
// 7. MAIN CLASS
// ============================================
public class LibraryProgram {
    public static void main(String[] args) {
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===\n");
        
        // 1. Encapsulation
        Book b1 = new Book(101, "Java Programming", "James", 599.99);
        Book b2 = new Book(102, "Python Basics", "Guido", 499.99);
        b1.displayInfo();
        System.out.println();
        
        // 2. Inheritance
        Student s1 = new Student(1, "Rahul", "rahul@email.com", "S001", "CS");
        Librarian l1 = new Librarian(101, "Kumar", "kumar@email.com", "L001", "Library", 10);
        s1.displayStudentInfo();
        l1.displayLibrarianInfo();
        System.out.println();
        
        // 3. Abstraction & 4. Polymorphism
        LibraryItem item = new Book(103, "Data Structures", "Robert", 799.99);
        item.displayInfo();
        System.out.println();
        
        // 5. Interface
        System.out.println("--- Borrowing ---");
        s1.borrowItem();
        b1.borrowItem();
        System.out.println();
        
        System.out.println("--- Librarian Issues Book ---");
        l1.issueBook(s1, b2);
        System.out.println();
        
        System.out.println("--- Librarian Receives Book ---");
        l1.receiveBook(s1, b2);
        
        System.out.println("\n✅ ALL OOP CONCEPTS DEMONSTRATED!");
    }
}