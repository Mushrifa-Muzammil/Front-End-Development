/**
 * Customer Class - Implements Runnable for Multithreading
 * Each customer attempts to book the same cab
 * Demonstrates concurrent booking attempts
 */
public class Customer implements Runnable {
    
    // ===== ATTRIBUTES =====
    private String customerName;
    private Cab cab;
    
    // ===== CONSTRUCTOR =====
    public Customer(String customerName, Cab cab) {
        this.customerName = customerName;
        this.cab = cab;
        System.out.println("👤 Customer " + customerName + " created.");
    }
    
    // ===== RUN METHOD - Thread execution starts here =====
    @Override
    public void run() {
        // Add small delay to simulate real-time booking attempts
        try {
            Thread.sleep(100);  // 100ms delay
        } catch (InterruptedException e) {
            System.out.println("⚠️ Thread interrupted for " + customerName);
        }
        
        // Attempt to book the cab
        cab.bookCab(customerName);
    }
    
    // ===== GETTER =====
    public String getCustomerName() {
        return customerName;
    }
}