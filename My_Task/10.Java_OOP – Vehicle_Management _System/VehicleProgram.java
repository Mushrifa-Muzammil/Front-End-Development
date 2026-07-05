import java.util.Scanner;

// ============================================
// 1. ABSTRACT CLASS - VEHICLE
// ============================================
abstract class Vehicle {
    protected String vehicleName;
    protected String vehicleType;
    
    public Vehicle(String vehicleName, String vehicleType) {
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        System.out.println("Vehicle Constructor Called: " + vehicleType);
    }
    
    public abstract void start();
    public abstract void stop();
    
    public void displayInfo() {
        System.out.println("==============================");
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("==============================");
    }
}

// ============================================
// 2. INTERFACE - FUEL EFFICIENCY
// ============================================
interface FuelEfficiency {
    void calculateMileage();
}

// ============================================
// 3. CAR CLASS
// ============================================
class Car extends Vehicle implements FuelEfficiency {
    private int numberOfDoors;
    private String fuelType;
    private double mileage;
    
    public Car(String vehicleName, int numberOfDoors, String fuelType, double mileage) {
        super(vehicleName, "Car");
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.mileage = mileage;
        System.out.println("Car Constructor Called!");
    }
    
    @Override
    public void start() {
        System.out.println("🚗 Car is Starting... Vroom Vroom!");
    }
    
    @Override
    public void stop() {
        System.out.println("🚗 Car is Stopping... Stopped!");
    }
    
    @Override
    public void calculateMileage() {
        System.out.println("======================================");
        System.out.println("   CAR MILEAGE");
        System.out.println("======================================");
        System.out.println("Vehicle: " + vehicleName);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Mileage: " + mileage + " km/liter");
        System.out.println("======================================");
    }
}

// ============================================
// 4. BIKE CLASS
// ============================================
class Bike extends Vehicle implements FuelEfficiency {
    private int engineCC;
    private String bikeType;
    private double mileage;
    
    public Bike(String vehicleName, int engineCC, String bikeType, double mileage) {
        super(vehicleName, "Bike");
        this.engineCC = engineCC;
        this.bikeType = bikeType;
        this.mileage = mileage;
        System.out.println("Bike Constructor Called!");
    }
    
    @Override
    public void start() {
        System.out.println("🏍️ Bike is Starting... Vroom!");
    }
    
    @Override
    public void stop() {
        System.out.println("🏍️ Bike is Stopping... Stopped!");
    }
    
    @Override
    public void calculateMileage() {
        System.out.println("======================================");
        System.out.println("   BIKE MILEAGE");
        System.out.println("======================================");
        System.out.println("Vehicle: " + vehicleName);
        System.out.println("Engine: " + engineCC + " CC");
        System.out.println("Bike Type: " + bikeType);
        System.out.println("Mileage: " + mileage + " km/liter");
        System.out.println("======================================");
    }
}

// ============================================
// 5. MAIN CLASS
// ============================================
public class VehicleProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   VEHICLE MANAGEMENT SYSTEM");
        System.out.println("========================================\n");
        
        // Car
        System.out.println("--- Enter Car Details ---");
        System.out.print("Name: ");
        String carName = input.nextLine();
        System.out.print("Doors: ");
        int doors = input.nextInt();
        input.nextLine();
        System.out.print("Fuel Type: ");
        String fuel = input.nextLine();
        System.out.print("Mileage (km/l): ");
        double carMileage = input.nextDouble();
        input.nextLine();
        
        Car car = new Car(carName, doors, fuel, carMileage);
        System.out.println();
        car.start();
        car.calculateMileage();
        car.stop();
        System.out.println();
        
        // Bike
        System.out.println("--- Enter Bike Details ---");
        System.out.print("Name: ");
        String bikeName = input.nextLine();
        System.out.print("Engine CC: ");
        int cc = input.nextInt();
        input.nextLine();
        System.out.print("Bike Type: ");
        String type = input.nextLine();
        System.out.print("Mileage (km/l): ");
        double bikeMileage = input.nextDouble();
        
        Bike bike = new Bike(bikeName, cc, type, bikeMileage);
        System.out.println();
        bike.start();
        bike.calculateMileage();
        bike.stop();
        
        input.close();
    }
}