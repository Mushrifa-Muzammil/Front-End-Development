import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// ---------------------- CLASS: BUS ----------------------
class Bus {
    private int busId;
    private String busName;
    private int totalCapacity;
    private int availableSeats;

    public Bus(int busId, String busName, int totalCapacity) {
        this.busId = busId;
        this.busName = busName;
        this.totalCapacity = totalCapacity;
        this.availableSeats = totalCapacity;
    }

    public int getBusId() { return busId; }
    public String getBusName() { return busName; }
    public int getTotalCapacity() { return totalCapacity; }
    public int getAvailableSeats() { return availableSeats; }

    public void setTotalCapacity(int newCapacity) {
        this.totalCapacity = newCapacity;
        // Ensure available seats don't exceed new capacity
        if (availableSeats > newCapacity) {
            availableSeats = newCapacity;
        }
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < totalCapacity) {
            availableSeats++;
        }
    }

    @Override
    public String toString() {
        return String.format("Bus ID: %-5d | Name: %-15s | Total Capacity: %-5d | Available Seats: %-5d", 
                             busId, busName, totalCapacity, availableSeats);
    }
}

// ---------------------- CLASS: BOOKING ----------------------
class Booking {
    private static int bookingCounter = 1000; // Auto-increment booking ID
    private int bookingId;
    private int busId;
    private String passengerName;

    public Booking(int busId, String passengerName) {
        this.bookingId = ++bookingCounter;
        this.busId = busId;
        this.passengerName = passengerName;
    }

    public int getBookingId() { return bookingId; }
    public int getBusId() { return busId; }
    public String getPassengerName() { return passengerName; }

    @Override
    public String toString() {
        return String.format("Booking ID: %-6d | Bus ID: %-5d | Passenger: %-15s", 
                             bookingId, busId, passengerName);
    }
}

// ---------------------- MAIN CLASS: BUS RESERVATION SYSTEM ----------------------
public class BusReservationSystem {
    private static ArrayList<Bus> buses = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextBusId = 1;

    public static void main(String[] args) {
        // Pre-add some sample buses for testing
        buses.add(new Bus(nextBusId++, "Express-1", 40));
        buses.add(new Bus(nextBusId++, "City Rider", 30));

        while (true) {
            printMenu();
            int choice = getValidIntegerInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addBus();
                    break;
                case 2:
                    viewAllBuses();
                    break;
                case 3:
                    updateBusCapacity();
                    break;
                case 4:
                    deleteBus();
                    break;
                case 5:
                    bookTicket();
                    break;
                case 6:
                    viewAllBookings();
                    break;
                case 7:
                    cancelBooking();
                    break;
                case 8:
                    System.out.println("\n🚪 Exiting the system. Thank you for using Bus Reservation!");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice. Please enter a number between 1 and 8.");
            }
            System.out.println("\n----------------------------------------------------");
        }
    }

    // ---------------------- MENU ----------------------
    private static void printMenu() {
        System.out.println("\n========== BUS RESERVATION SYSTEM ==========");
        System.out.println("1. Add Bus");
        System.out.println("2. View All Buses");
        System.out.println("3. Update Bus Capacity");
        System.out.println("4. Delete Bus");
        System.out.println("5. Book Ticket");
        System.out.println("6. View All Bookings");
        System.out.println("7. Cancel Booking");
        System.out.println("8. Exit");
        System.out.println("=============================================");
    }

    // ---------------------- 1. ADD BUS ----------------------
    private static void addBus() {
        System.out.println("\n--- Add New Bus ---");
        System.out.print("Enter Bus Name: ");
        String name = scanner.nextLine();
        int capacity = getValidIntegerInput("Enter Total Capacity: ");

        Bus newBus = new Bus(nextBusId++, name, capacity);
        buses.add(newBus);
        System.out.println("✅ Bus added successfully! Bus ID: " + (nextBusId - 1));
    }

    // ---------------------- 2. VIEW ALL BUSES ----------------------
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

    // ---------------------- 3. UPDATE BUS CAPACITY ----------------------
    private static void updateBusCapacity() {
        System.out.println("\n--- Update Bus Capacity ---");
        int id = getValidIntegerInput("Enter Bus ID to update: ");
        Bus bus = findBusById(id);

        if (bus == null) {
            System.out.println("❌ Bus with ID " + id + " not found.");
            return;
        }

        System.out.println("Current Capacity: " + bus.getTotalCapacity());
        int newCapacity = getValidIntegerInput("Enter New Capacity: ");
        
        if (newCapacity < 0) {
            System.out.println("❌ Capacity cannot be negative.");
            return;
        }
        bus.setTotalCapacity(newCapacity);
        System.out.println("✅ Bus capacity updated successfully!");
    }

    // ---------------------- 4. DELETE BUS ----------------------
    private static void deleteBus() {
        System.out.println("\n--- Delete Bus ---");
        int id = getValidIntegerInput("Enter Bus ID to delete: ");
        Bus bus = findBusById(id);

        if (bus == null) {
            System.out.println("❌ Bus with ID " + id + " not found.");
            return;
        }

        // Remove associated bookings for this bus
        bookings.removeIf(b -> b.getBusId() == id);
        
        buses.remove(bus);
        System.out.println("✅ Bus deleted successfully! Associated bookings were also removed.");
    }

    // ---------------------- 5. BOOK TICKET ----------------------
    private static void bookTicket() {
        System.out.println("\n--- Book Ticket ---");
        int id = getValidIntegerInput("Enter Bus ID to book a seat: ");
        Bus bus = findBusById(id);

        if (bus == null) {
            System.out.println("❌ Bus with ID " + id + " not found.");
            return;
        }

        if (bus.getAvailableSeats() == 0) {
            System.out.println("❌ Sorry, no seats available on this bus.");
            return;
        }

        System.out.print("Enter Passenger Name: ");
        String passengerName = scanner.nextLine();

        if (bus.bookSeat()) {
            Booking newBooking = new Booking(id, passengerName);
            bookings.add(newBooking);
            System.out.println("✅ Ticket booked successfully! Booking ID: " + newBooking.getBookingId());
        } else {
            System.out.println("❌ Failed to book ticket. Unexpected error.");
        }
    }

    // ---------------------- 6. VIEW ALL BOOKINGS ----------------------
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

    // ---------------------- 7. CANCEL BOOKING ----------------------
    private static void cancelBooking() {
        System.out.println("\n--- Cancel Booking ---");
        int bookId = getValidIntegerInput("Enter Booking ID to cancel: ");
        Booking bookingToCancel = null;

        for (Booking b : bookings) {
            if (b.getBookingId() == bookId) {
                bookingToCancel = b;
                break;
            }
        }

        if (bookingToCancel == null) {
            System.out.println("❌ Booking ID " + bookId + " not found.");
            return;
        }

        // Update available seats on the bus
        Bus bus = findBusById(bookingToCancel.getBusId());
        if (bus != null) {
            bus.cancelSeat();
        }

        bookings.remove(bookingToCancel);
        System.out.println("✅ Booking cancelled successfully! Seat restored.");
    }

    // ---------------------- HELPER METHODS ----------------------
    private static Bus findBusById(int id) {
        for (Bus b : buses) {
            if (b.getBusId() == id) {
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
}