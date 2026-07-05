/**
 * Car Class - Extends Vehicle, Implements FuelEfficiency
 * Demonstrates:
 *   - Inheritance (extends Vehicle)
 *   - Interface Implementation (implements FuelEfficiency)
 *   - Method Overriding
 */
public class Car extends Vehicle implements FuelEfficiency {
    
    // ===== CAR SPECIFIC ATTRIBUTES =====
    private int numberOfDoors;
    private String fuelType;
    private double mileage;
    
    // ===== CONSTRUCTOR =====
    public Car(String vehicleName, int numberOfDoors, String fuelType, double mileage) {
        super(vehicleName, "Car");
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.mileage = mileage;
        System.out.println("Car Constructor Called!");
    }
    
    // ===== IMPLEMENTATION OF start() =====
    @Override
    public void start() {
        System.out.println("🚗 Car is Starting...");
        System.out.println("   Engine started!");
        System.out.println("   Vroom Vroom! " + vehicleName + " is ready to go!");
    }
    
    // ===== IMPLEMENTATION OF stop() =====
    @Override
    public void stop() {
        System.out.println("🚗 Car is Stopping...");
        System.out.println("   Applying brakes!");
        System.out.println("   Engine turned off!");
        System.out.println("   " + vehicleName + " has stopped!");
    }
    
    // ===== IMPLEMENTATION OF calculateMileage() =====
    @Override
    public void calculateMileage() {
        System.out.println("======================================");
        System.out.println("   CAR MILEAGE CALCULATION");
        System.out.println("======================================");
        System.out.println("Vehicle: " + vehicleName);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Mileage: " + mileage + " km/liter");
        System.out.println("Fuel Efficiency: Good!");
        System.out.println("======================================");
    }
}