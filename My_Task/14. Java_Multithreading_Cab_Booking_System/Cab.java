/**
 * Cab Class - Represents a single cab in the booking system
 * Demonstrates thread safety using synchronized keyword
 * Attributes: availability status (available/booked)
 */
public class Cab {
    
    // ===== ATTRIBUTES =====
    private boolean isAvailable;  // true = available, false = booked
    private String cabId;
    
    // ===== CONSTRUCTOR =====
    public Cab(String cabId) {
        this.cabId = cabId;
        this.isAvailable = true;  // Initially available
        System.out.println("🚖 Cab " + cabId + " created and is AVAILABLE for booking.");
    }
    
    // ===== SYNCHRONIZED METHOD TO BOOK CAB =====
    // Only one thread can execute this method at a time
    public synchronized boolean bookCab(String customerName) {
        
        System.out.println("\n📞 Customer " + customerName + " is trying to book Cab " + cabId + "...");
        
        // Check if cab is available
        if (isAvailable) {
            // Book the cab
            isAvailable = false;
            System.out.println("✅ Customer " + customerName + " SUCCESSFULLY booked Cab " + cabId + "!");
            return true;
        } else {
            // Cab is already booked
            System.out.println("❌ Customer " + customerName + " FAILED to book Cab " + cabId + ". Cab is already booked!");
            return false;
        }
    }
    
    // ===== GETTER METHODS =====
    public String getCabId() {
        return cabId;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
}