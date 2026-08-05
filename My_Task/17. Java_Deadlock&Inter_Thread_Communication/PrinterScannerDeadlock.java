/**
 * Task 01 - Deadlock Version
 * This version demonstrates deadlock where User1 locks Printer first then Scanner,
 * while User2 locks Scanner first then Printer.
 */
class Printer {
    public void print(String user) {
        System.out.println(user + " is using the Printer...");
        try {
            Thread.sleep(1000); // Simulating printing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(user + " finished using the Printer.");
    }
}

class Scanner {
    public void scan(String user) {
        System.out.println(user + " is using the Scanner...");
        try {
            Thread.sleep(1000); // Simulating scanning time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(user + " finished using the Scanner.");
    }
}

public class PrinterScannerDeadlock {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner scanner = new Scanner();
        
        // User1: Locks Printer first, then Scanner
        Thread user1 = new Thread(() -> {
            synchronized (printer) {
                System.out.println("User1 locked Printer");
                try {
                    Thread.sleep(100); // Small delay to increase deadlock chance
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                synchronized (scanner) {
                    System.out.println("User1 locked Scanner");
                    printer.print("User1");
                    scanner.scan("User1");
                }
            }
        });
        
        // User2: Locks Scanner first, then Printer
        Thread user2 = new Thread(() -> {
            synchronized (scanner) {
                System.out.println("User2 locked Scanner");
                try {
                    Thread.sleep(100); // Small delay to increase deadlock chance
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                synchronized (printer) {
                    System.out.println("User2 locked Printer");
                    printer.print("User2");
                    scanner.scan("User2");
                }
            }
        });
        
        user1.start();
        user2.start();
    }
}