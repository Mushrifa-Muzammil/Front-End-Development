/**
 * LibraryManagementSystem - Main Class
 * Demonstrates all OOP Concepts:
 * 1. Encapsulation
 * 2. Inheritance
 * 3. Abstraction
 * 4. Polymorphism
 * 5. Interface
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM");
        System.out.println("   Demonstrating all OOP Concepts");
        System.out.println("===========================================\n");
        
        // ==========================================
        // 1. ENCAPSULATION - Book Class
        // ==========================================
        System.out.println("📚 1. ENCAPSULATION - Book Class");
        System.out.println("-------------------------------------------");
        
        Book book1 = new Book(101, "Java Programming", "James Gosling", 599.99);
        Book book2 = new Book(102, "Python Basics", "Guido van Rossum", 499.99);
        System.out.println();
        
        System.out.println("--- Using Getters and Setters ---");
        System.out.println("Book 1 Title: " + book1.getTitle());
        System.out.println("Book 1 Price: ₹" + book1.getPrice());
        book1.setPrice(649.99);
        System.out.println("Book 1 Updated Price: ₹" + book1.getPrice());
        System.out.println();
        
        // ==========================================
        // 2. INHERITANCE - Person → Student, Librarian
        // ==========================================
        System.out.println("👤 2. INHERITANCE - Person → Student, Librarian");
        System.out.println("-------------------------------------------");
        
        Student student1 = new Student(1, "Rahul Sharma", "rahul@email.com", "S001", "Computer Science");
        Student student2 = new Student(2, "Priya Patel", "priya@email.com", "S002", "Mathematics");
        System.out.println();
        
        Librarian librarian = new Librarian(101, "Mr. Kumar", "kumar@email.com", "L001", "Library", 10);
        System.out.println();
        
        student1.displayStudentInfo();
        System.out.println();
        librarian.displayLibrarianInfo();
        System.out.println();
        
        // ==========================================
        // 3. ABSTRACTION - LibraryItem → Book
        // ==========================================
        System.out.println("📖 3. ABSTRACTION - LibraryItem → Book");
        System.out.println("-------------------------------------------");
        book1.displayInfo();
        System.out.println();
        
        // ==========================================
        // 4. POLYMORPHISM - Method Overriding
        // ==========================================
        System.out.println("🔄 4. POLYMORPHISM - Method Overriding");
        System.out.println("-------------------------------------------");
        
        LibraryItem item = new Book(104, "Effective Java", "Joshua Bloch", 899.99);
        item.displayInfo();
        System.out.println();
        
        // ==========================================
        // 5. INTERFACE - Borrowable
        // ==========================================
        System.out.println("🔁 5. INTERFACE - Borrowable");
        System.out.println("-------------------------------------------");
        
        System.out.println("--- Student Borrowing Book ---");
        student1.borrowItem();
        book1.borrowItem();
        System.out.println();
        
        System.out.println("--- Librarian Issuing Book ---");
        librarian.issueBook(student2, book2);
        System.out.println();
        
        System.out.println("--- Librarian Receiving Book ---");
        librarian.receiveBook(student2, book2);
        System.out.println();
        
        // ==========================================
        // 6. SUMMARY
        // ==========================================
        System.out.println("===========================================");
        System.out.println("   OOP CONCEPTS SUMMARY");
        System.out.println("===========================================");
        System.out.println("\n✅ Encapsulation  : Book class with private attributes + getters/setters");
        System.out.println("✅ Inheritance    : Student and Librarian extend Person");
        System.out.println("✅ Abstraction    : LibraryItem abstract class with displayInfo()");
        System.out.println("✅ Polymorphism   : LibraryItem item = new Book(); displayInfo() overridden");
        System.out.println("✅ Interface      : Borrowable interface with borrowItem() and returnItem()");
        System.out.println("\n===========================================");
        System.out.println("   PROGRAM EXECUTED SUCCESSFULLY!");
        System.out.println("===========================================");
    }
}