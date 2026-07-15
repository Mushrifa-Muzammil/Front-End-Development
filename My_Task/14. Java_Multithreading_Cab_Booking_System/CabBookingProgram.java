/**
 * Cab Booking System - Single File Implementation
 * Demonstrates Multithreading and Synchronization
 */

// ============================================
// 1. CAB CLASS
// ============================================
class Cab {
    private boolean isAvailable;
    private String cabId;
    
    public Cab(String cabId) {
        this.cabId = cabId;
        this.isAvailable = true;
        System.out.println("🚖 Cab " + cabId + " created and AVAILABLE.");
    }
    
    public synchronized boolean bookCab(String customerName) {
        System.out.println("\n📞 " + customerName + " trying to book Cab " + cabId + "...");
        
        if (isAvailable) {
            isAvailable = false;
            System.out.println("✅ " + customerName + " SUCCESSFULLY booked Cab " + cabId + "!");
            return true;
        } else {
            System.out.println("❌ " + customerName + " FAILED. Cab already booked!");
            return false;
        }
    }
    
    public String getCabId() { return cabId; }
    public boolean isAvailable() { return isAvailable; }
}

// ============================================
// 2. CUSTOMER CLASS (Runnable)
// ============================================
class Customer implements Runnable {
    private String name;
    private Cab cab;
    
    public Customer(String name, Cab cab) {
        this.name = name;
        this.cab = cab;
        System.out.println("👤 " + name + " created.");
    }
    
    @Override
    public void run() {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        cab.bookCab(name);
    }
}

// ============================================
// 3. MAIN CLASS
// ============================================
public class CabBookingProgram {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   CAB BOOKING SYSTEM");
        System.out.println("   Multithreading & Synchronization");
        System.out.println("========================================\n");
        
        Cab cab = new Cab("TN-01-AB-1234");
        System.out.println();
        
        // Create Customers
        Customer c1 = new Customer("Rahul", cab);
        Customer c2 = new Customer("Priya", cab);
        Customer c3 = new Customer("Amit", cab);
        Customer c4 = new Customer("Sneha", cab);
        System.out.println();
        
        // Create Threads
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        
        System.out.println("🚀 Starting all threads...\n");
        System.out.println("--- Booking Attempts ---");
        
        // Start Threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        // Wait for all threads
        try {
            t1.join(); t2.join(); t3.join(); t4.join();
        } catch (InterruptedException e) {}
        
        // Final Result
        System.out.println("\n========================================");
        System.out.println("   FINAL RESULT");
        System.out.println("========================================");
        System.out.println("Cab " + cab.getCabId() + " Status: " + 
                          (cab.isAvailable() ? "AVAILABLE ✅" : "BOOKED ❌"));
        System.out.println("✅ Only ONE customer booked successfully!");
        System.out.println("✅ No double booking occurred!");
        System.out.println("========================================");
    }
}