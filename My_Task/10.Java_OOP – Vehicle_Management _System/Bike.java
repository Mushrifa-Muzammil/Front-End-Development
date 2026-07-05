/**
 * Bike Class - Extends Vehicle, Implements FuelEfficiency
 * Demonstrates:
 *   - Inheritance (extends Vehicle)
 *   - Interface Implementation (implements FuelEfficiency)
 *   - Method Overriding
 */
public class Bike extends Vehicle implements FuelEfficiency {
    
    // ===== BIKE SPECIFIC ATTRIBUTES =====
    private int engineCC;
    private String bikeType;
    private double mileage;
    
    // ===== CONSTRUCTOR =====
    public Bike(String vehicleName, int engineCC, String bikeType, double mileage) {
        super(vehicleName, "Bike");
        this.engineCC = engineCC;
        this.bikeType = bikeType;
        this.mileage = mileage;
        System.out.println("Bike Constructor Called!");
    }
    
    // ===== IMPLEMENTATION OF start() =====
    @Override
    public void start() {
        System.out.println("🏍️ Bike is Starting...");
        System.out.println("   Kick-starting the engine!");
        System.out.println("   Vroom! " + vehicleName + " is ready to ride!");
    }
    
    // ===== IMPLEMENTATION OF stop() =====
    @Override
    public void stop() {
        System.out.println("🏍️ Bike is Stopping...");
        System.out.println("   Applying brakes!");
        System.out.println("   Engine turned off!");
        System.out.println("   " + vehicleName + " has stopped!");
    }
    
    // ===== IMPLEMENTATION OF calculateMileage() =====
    @Override
    public void calculateMileage() {
        System.out.println("======================================");
        System.out.println("   BIKE MILEAGE CALCULATION");
        System.out.println("======================================");
        System.out.println("Vehicle: " + vehicleName);
        System.out.println("Bike Type: " + bikeType);
        System.out.println("Engine: " + engineCC + " CC");
        System.out.println("Mileage: " + mileage + " km/liter");
        System.out.println("Fuel Efficiency: Excellent!");
        System.out.println("======================================");
    }
}