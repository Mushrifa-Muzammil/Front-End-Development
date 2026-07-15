/**
 * NumberPrinter.java
 * Task 02 - Number Printer
 * Demonstrates: sleep(), synchronized methods, odd/even thread separation
 */

class NumberPrintManager {
    private int currentNumber = 1;
    private final int MAX_NUMBER = 20;
    private final Object lock = new Object();
    
    // Synchronized method to print odd numbers
    public synchronized void printOdd() {
        System.out.println("Odd Thread started");
        
        for (int i = 1; i <= MAX_NUMBER; i += 2) {
            System.out.println("Odd: " + i);
            
            // Sleep to simulate delay and show interleaving
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Odd thread interrupted");
            }
        }
    }
    
    // Synchronized method to print even numbers
    public synchronized void printEven() {
        System.out.println("Even Thread started");
        
        for (int i = 2; i <= MAX_NUMBER; i += 2) {
            System.out.println("Even: " + i);
            
            // Sleep to simulate delay and show interleaving
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Even thread interrupted");
            }
        }
    }
}

class OddNumberThread extends Thread {
    private NumberPrintManager manager;
    
    public OddNumberThread(NumberPrintManager manager) {
        super("Odd-Printer");
        this.manager = manager;
    }
    
    @Override
    public void run() {
        manager.printOdd();
        System.out.println("Odd thread finished");
    }
}

class EvenNumberThread extends Thread {
    private NumberPrintManager manager;
    
    public EvenNumberThread(NumberPrintManager manager) {
        super("Even-Printer");
        this.manager = manager;
    }
    
    @Override
    public void run() {
        manager.printEven();
        System.out.println("Even thread finished");
    }
}

public class NumberPrinter {
    public static void main(String[] args) {
        System.out.println("=== Number Printer (Odd and Even Numbers) ===");
        System.out.println("Maximum Number: 20\n");
        
        NumberPrintManager manager = new NumberPrintManager();
        
        // Create threads
        OddNumberThread oddThread = new OddNumberThread(manager);
        EvenNumberThread evenThread = new EvenNumberThread(manager);
        
        // Start threads
        System.out.println("Starting Odd and Even number threads...\n");
        oddThread.start();
        evenThread.start();
        
        // Wait for both threads to complete
        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        System.out.println("\nNumber printing completed.");
    }
}