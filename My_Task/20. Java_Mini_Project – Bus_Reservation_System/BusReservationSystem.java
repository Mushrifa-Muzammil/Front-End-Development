import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// ---------------------- CLASS: BUS ----------------------
class Bus {
    private String busNumber;
    private String source;
    private String destination;
    private int capacity;
    private int bookedSeats;

    public Bus(String busNumber, String source, String destination, int capacity) {
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    // Getters
    public String getBusNumber() { return busNumber; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getCapacity() { return capacity; }
    public int getBookedSeats() { return bookedSeats; }
    public int getAvailableSeats() { return capacity - bookedSeats; }

    // Setters (For updating capacity)
    public void setCapacity(int newCapacity) {
        if (newCapacity < bookedSeats) {
            System.out.println("❌ Error: New capacity cannot be less than already booked seats (" + bookedSeats + ").");
            return;
        }
        this.capacity = newCapacity;
        System.out.println("✅ Capacity updated successfully!");
    }

    // Book a seat
    public boolean bookSeat() {
        if (getAvailableSeats() > 0) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    // Cancel a seat
    public void cancelSeat() {
        if (bookedSeats > 0) {
            bookedSeats--;
        }
    }

    @Override
    public String toString() {
        return String.format("Bus No: %-8s | %-10s → %-10s | Capacity: %-4d | Booked: %-4d | Available: %-4d", 
                             busNumber, source, destination, capacity, bookedSeats, getAvailableSeats());
    }
}

// ---------------------- CLASS: BOOKING ----------------------
class Booking {
    private String passengerId;
    private String passengerName;
    private String busNumber;
    private String source;
    private String destination;

    public Booking(String passengerId, String passengerName, Bus bus) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.busNumber = bus.getBusNumber();
        this.source = bus.getSource();
        this.destination = bus.getDestination();
    }

    public String getPassengerId() { return passengerId; }
    public String getBusNumber() { return busNumber; }

    @Override
    public String toString() {
        return String.format("Passenger ID: %-10s | Name: %-12s | Bus No: %-8s | %-10s → %-10s", 
                             passengerId, passengerName, busNumber, source, destination);
    }
}

// ---------------------- MAIN CLASS: BUS RESERVATION SYSTEM ----------------------
public class BusReservationSystem {
    private static ArrayList<Bus> buses = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-add some sample buses for testing
        buses.add(new Bus("B001", "Chennai", "Bangalore", 40));
        buses.add(new Bus("B002", "Mumbai", "Pune", 30));

        while (true) {
            printMenu();
            int choice = getValidIntegerInput("Enter your choice: ");

            switch (choice) {
                case 1: // Module 01: Add Bus
                    addBus();
                    break;
                case 2: // Module 01: View All Buses
                    viewAllBuses();
                    break;
                case 3: // Module 01: Update Bus Capacity
                    updateBusCapacity();
                    break;
                case 4: // Module 01: Delete Bus
                    deleteBus();
                    break;
                case 5: // Module 01: Search Bus
                    searchBus();
                    break;
                case 6: // Module 02: Book Ticket
                    bookTicket();
                    break;
                case 7: // Module 03: View Bookings
                    viewAllBookings();
                    break;
                case 8: // Module 04: Cancel Booking
                    cancelBooking();
                    break;
                case 9: // Module 05: Exit
                    System.out.println("\n🚪 Exiting the system. Thank you for using Bus Reservation!");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice. Please enter a number between 1 and 9.");
            }
            System.out.println("\n----------------------------------------------------");
        }
    }

    // ---------------------- MENU ----------------------
    private static void printMenu() {
        System.out.println("\n========== BUS RESERVATION SYSTEM ==========");
        System.out.println("--- Module 01: Bus Management ---");
        System.out.println("1. Add Bus");
        System.out.println("2. View All Buses");
        System.out.println("3. Update Bus Capacity");
        System.out.println("4. Delete Bus");
        System.out.println("5. Search Bus by Number");
        System.out.println("--- Module 02 to 05 ---");
        System.out.println("6. Book Ticket");
        System.out.println("7. View All Bookings");
        System.out.println("8. Cancel Booking");
        System.out.println("9. Exit");
        System.out.println("=============================================");
    }

    // ---------------------- MODULE 01: BUS MANAGEMENT ----------------------
    private static void addBus() {
        System.out.println("\n--- Add New Bus ---");
        System.out.print("Enter Bus Number (e.g., B003): ");
        String busNum = scanner.nextLine().trim();
        
        if (findBusByNumber(busNum) != null) {
            System.out.println("❌ Bus number " + busNum + " already exists!");
            return;
        }

        System.out.print("Enter Source: ");
        String source = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String dest = scanner.nextLine();
        int cap = getValidIntegerInput("Enter Total Capacity: ");

        buses.add(new Bus(busNum, source, dest, cap));
        System.out.println("✅ Bus added successfully!");
    }

    private static void viewAllBuses() {
        System.out.println("\n--- Available Buses ---");
        if (buses.isEmpty()) {
            System.out.println("⚠️ No buses available in the system.");
            return;
        }
        for (Bus b : buses) {
            System.out.println(b);
        }
    }

    private static void updateBusCapacity() {
        System.out.println("\n--- Update Bus Capacity ---");
        String num = getValidBusNumberInput("Enter Bus Number to update: ");
        Bus bus = findBusByNumber(num);

        if (bus == null) {
            System.out.println("❌ Bus with number " + num + " not found.");
            return;
        }

        System.out.println("Current Capacity: " + bus.getCapacity() + " | Booked: " + bus.getBookedSeats());
        int newCapacity = getValidIntegerInput("Enter New Capacity: ");
        bus.setCapacity(newCapacity);
    }

    private static void deleteBus() {
        System.out.println("\n--- Delete Bus ---");
        String num = getValidBusNumberInput("Enter Bus Number to delete: ");
        Bus bus = findBusByNumber(num);

        if (bus == null) {
            System.out.println("❌ Bus with number " + num + " not found.");
            return;
        }

        // Remove associated bookings for this bus
        bookings.removeIf(b -> b.getBusNumber().equals(num));
        buses.remove(bus);
        System.out.println("✅ Bus deleted successfully! Associated bookings removed.");
    }

    private static void searchBus() {
        System.out.println("\n--- Search Bus ---");
        String num = getValidBusNumberInput("Enter Bus Number to search: ");
        Bus bus = findBusByNumber(num);

        if (bus == null) {
            System.out.println("❌ Bus with number " + num + " not found.");
            return;
        }
        System.out.println("✔️ Bus found:");
        System.out.println(bus);
    }

    // ---------------------- MODULE 02: TICKET BOOKING ----------------------
    private static void bookTicket() {
        System.out.println("\n--- Book Ticket ---");
        System.out.print("Enter Passenger Name: ");
        String pName = scanner.nextLine();

        System.out.print("Enter Passenger ID (Unique): ");
        String pId = scanner.nextLine().trim();

        // Ensure Passenger ID is unique
        for (Booking b : bookings) {
            if (b.getPassengerId().equals(pId)) {
                System.out.println("❌ Passenger ID '" + pId + "' is already taken! Please use a unique ID.");
                return;
            }
        }

        String busNum = getValidBusNumberInput("Enter Bus Number to book a seat: ");
        Bus bus = findBusByNumber(busNum);

        if (bus == null) {
            System.out.println("❌ Bus with number " + busNum + " not found.");
            return;
        }

        if (bus.getAvailableSeats() == 0) {
            System.out.println("❌ Sorry, no seats available on this bus.");
            return;
        }

        // Book the seat
        if (bus.bookSeat()) {
            Booking newBooking = new Booking(pId, pName, bus);
            bookings.add(newBooking);
            System.out.println("✅ Ticket booked successfully!");
        } else {
            System.out.println("❌ Failed to book ticket. Unexpected error.");
        }
    }

    // ---------------------- MODULE 03: VIEW BOOKINGS ----------------------
    private static void viewAllBookings() {
        System.out.println("\n--- All Bookings ---");
        if (bookings.isEmpty()) {
            System.out.println("⚠️ No bookings found in the system.");
            return;
        }
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    // ---------------------- MODULE 04: CANCEL BOOKING ----------------------
    private static void cancelBooking() {
        System.out.println("\n--- Cancel Booking ---");
        System.out.print("Enter Passenger ID to cancel booking: ");
        String pId = scanner.nextLine().trim();

        Booking bookingToCancel = null;
        for (Booking b : bookings) {
            if (b.getPassengerId().equals(pId)) {
                bookingToCancel = b;
                break;
            }
        }

        if (bookingToCancel == null) {
            System.out.println("❌ Booking with Passenger ID '" + pId + "' not found.");
            return;
        }

        // Update available seats on the bus
        Bus bus = findBusByNumber(bookingToCancel.getBusNumber());
        if (bus != null) {
            bus.cancelSeat();
        }

        bookings.remove(bookingToCancel);
        System.out.println("✅ Booking cancelled successfully! Seat restored.");
    }

    // ---------------------- HELPER METHODS ----------------------
    private static Bus findBusByNumber(String busNumber) {
        for (Bus b : buses) {
            if (b.getBusNumber().equalsIgnoreCase(busNumber)) {
                return b;
            }
        }
        return null;
    }

    private static int getValidIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                return input;
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private static String getValidBusNumberInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}