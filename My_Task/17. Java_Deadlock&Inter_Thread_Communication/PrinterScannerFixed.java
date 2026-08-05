/**
 * Task 01 - Fixed Version
 * This version prevents deadlock by using consistent lock ordering.
 * Both users lock Printer first, then Scanner.
 * Uses wait() and notifyAll() for resource management.
 */
import java.util.concurrent.atomic.AtomicBoolean;

class PrinterResource {
    private boolean isBusy = false;
    
    public synchronized void use(String user) throws InterruptedException {
        while (isBusy) {
            System.out.println(user + " is waiting for Printer...");
            wait();
        }
        isBusy = true;
        System.out.println(user + " is using the Printer...");
        Thread.sleep(1000); // Simulating printing time
        System.out.println(user + " finished using the Printer.");
        isBusy = false;
        notifyAll();
    }
}

class ScannerResource {
    private boolean isBusy = false;
    
    public synchronized void use(String user) throws InterruptedException {
        while (isBusy) {
            System.out.println(user + " is waiting for Scanner...");
            wait();
        }
        isBusy = true;
        System.out.println(user + " is using the Scanner...");
        Thread.sleep(1000); // Simulating scanning time
        System.out.println(user + " finished using the Scanner.");
        isBusy = false;
        notifyAll();
    }
}

public class PrinterScannerFixed {
    public static void main(String[] args) {
        PrinterResource printer = new PrinterResource();
        ScannerResource scanner = new ScannerResource();
        
        // Both users will lock Printer first, then Scanner (consistent ordering)
        Thread user1 = new Thread(() -> {
            try {
                // User1: Printer first, then Scanner
                synchronized (printer) {
                    printer.use("User1");
                    synchronized (scanner) {
                        scanner.use("User1");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        Thread user2 = new Thread(() -> {
            try {
                // User2: Also Printer first, then Scanner
                synchronized (printer) {
                    printer.use("User2");
                    synchronized (scanner) {
                        scanner.use("User2");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        user1.start();
        user2.start();
    }
}