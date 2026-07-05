/**
 * Vehicle - Abstract Class
 * Demonstrates Abstraction in Java
 * Abstract methods: start(), stop()
 */
public abstract class Vehicle {
    
    // ===== ATTRIBUTES =====
    protected String vehicleName;
    protected String vehicleType;
    
    // ===== CONSTRUCTOR =====
    public Vehicle(String vehicleName, String vehicleType) {
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        System.out.println("Vehicle Constructor Called: " + vehicleType);
    }
    
    // ===== ABSTRACT METHODS (Must be implemented by child classes) =====
    public abstract void start();
    public abstract void stop();
    
    // ===== CONCRETE METHOD (Common for all vehicles) =====
    public void displayInfo() {
        System.out.println("==============================");
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("==============================");
    }
}