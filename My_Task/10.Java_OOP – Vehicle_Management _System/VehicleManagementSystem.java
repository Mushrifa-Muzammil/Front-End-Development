/**
 * VehicleManagementSystem - Main Class
 * Tests the Vehicle Management System
 * Demonstrates Abstraction, Interface, and Inheritance
 */
public class VehicleManagementSystem {
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   VEHICLE MANAGEMENT SYSTEM");
        System.out.println("   Demonstrating Abstraction & Interface");
        System.out.println("===========================================\n");
        
        // ==========================================
        // 1. CREATE CAR OBJECT
        // ==========================================
        System.out.println("--- CREATING CAR ---");
        Car car = new Car("Toyota Camry", 4, "Petrol", 15.5);
        System.out.println();
        
        System.out.println("--- CAR OPERATIONS ---");
        car.displayInfo();
        car.start();
        car.calculateMileage();
        car.stop();
        System.out.println();
        
        // ==========================================
        // 2. CREATE BIKE OBJECT
        // ==========================================
        System.out.println("--- CREATING BIKE ---");
        Bike bike = new Bike("Yamaha R15", 155, "Sports", 45.0);
        System.out.println();
        
        System.out.println("--- BIKE OPERATIONS ---");
        bike.displayInfo();
        bike.start();
        bike.calculateMileage();
        bike.stop();
        System.out.println();
        
        // ==========================================
        // 3. SUMMARY
        // ==========================================
        System.out.println("===========================================");
        System.out.println("   VEHICLE MANAGEMENT SUMMARY");
        System.out.println("===========================================");
        System.out.println("\n✅ Car: Toyota Camry (Petrol, 15.5 km/l)");
        System.out.println("✅ Bike: Yamaha R15 (Sports, 45.0 km/l)");
        System.out.println("\n===========================================");
        System.out.println("   PROGRAM EXECUTED SUCCESSFULLY!");
        System.out.println("===========================================");
    }
}