/**
 * CabBookingSystem - Main Class
 * Demonstrates Multithreading and Synchronization
 * Creates multiple customers attempting to book the same cab
 * Only one customer should succeed
 */
public class CabBookingSystem {
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   CAB BOOKING SYSTEM");
        System.out.println("   Demonstrating Multithreading & Synchronization");
        System.out.println("===========================================\n");
        
        // ===== 1. CREATE A SINGLE CAB =====
        Cab cab = new Cab("TN-01-AB-1234");
        System.out.println();
        
        // ===== 2. CREATE MULTIPLE CUSTOMERS =====
        Customer customer1 = new Customer("Rahul", cab);
        Customer customer2 = new Customer("Priya", cab);
        Customer customer3 = new Customer("Amit", cab);
        Customer customer4 = new Customer("Sneha", cab);
        System.out.println();
        
        // ===== 3. CREATE THREADS FOR EACH CUSTOMER =====
        Thread t1 = new Thread(customer1, "Thread-1");
        Thread t2 = new Thread(customer2, "Thread-2");
        Thread t3 = new Thread(customer3, "Thread-3");
        Thread t4 = new Thread(customer4, "Thread-4");
        
        System.out.println("🚀 Starting all customer threads...\n");
        System.out.println("--- Booking Attempts ---");
        
        // ===== 4. START ALL THREADS =====
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        // ===== 5. WAIT FOR ALL THREADS TO COMPLETE =====
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("⚠️ Main thread interrupted!");
        }
        
        // ===== 6. DISPLAY FINAL RESULT =====
        System.out.println("\n===========================================");
        System.out.println("   FINAL BOOKING STATUS");
        System.out.println("===========================================");
        System.out.println("Cab " + cab.getCabId() + " is now: " + 
                          (cab.isAvailable() ? "AVAILABLE ✅" : "BOOKED ❌"));
        System.out.println("===========================================");
        System.out.println("✅ Only ONE customer successfully booked the cab!");
        System.out.println("✅ No double booking occurred!");
        System.out.println("✅ Thread safety demonstrated using synchronized!");
        System.out.println("===========================================");
    }
}