/**
 * Book Class - Demonstrates:
 * 1. Encapsulation (private attributes + getters/setters)
 * 2. Abstraction (extends LibraryItem)
 * 3. Interface (implements Borrowable)
 */
public class Book extends LibraryItem implements Borrowable {
    
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
        System.out.println("📚 Book Created: " + title);
    }
    
    // Getters
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public boolean isBorrowed() { return isBorrowed; }
    
    // Setters
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
            System.out.println("✅ Book '" + title + "' borrowed successfully!");
        } else {
            System.out.println("❌ Book '" + title + "' is already borrowed!");
        }
    }
    
    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("✅ Book '" + title + "' returned successfully!");
        } else {
            System.out.println("❌ Book '" + title + "' was not borrowed!");
        }
    }
}