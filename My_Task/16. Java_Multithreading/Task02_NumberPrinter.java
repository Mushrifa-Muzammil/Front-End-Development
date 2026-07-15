/**
 * Task 02 - Number Printer
 * Demonstrates: synchronized, sleep()
 * One thread prints odd numbers, another prints even numbers
 */
public class Task02_NumberPrinter {
    
    // ===== SYNCHRONIZED PRINT METHOD =====
    public synchronized void printNumber(int number, String threadName) {
        System.out.println(threadName + " ➜ " + number);
        try {
            Thread.sleep(100); // Delay between prints
        } catch (InterruptedException e) {
            System.out.println("⚠️ " + threadName + " interrupted!");
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   TASK 02 - NUMBER PRINTER");
        System.out.println("   Odd & Even Numbers with Synchronization");
        System.out.println("===========================================\n");
        
        Task02_NumberPrinter printer = new Task02_NumberPrinter();
        
        // ===== THREAD 1: ODD NUMBERS =====
        Thread oddThread = new Thread(() -> {
            System.out.println("\n🔵 Odd Thread Started...");
            for (int i = 1; i <= 10; i += 2) {
                printer.printNumber(i, "Odd");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("⚠️ Odd thread interrupted!");
                }
            }
            System.out.println("🏁 Odd Thread Completed!");
        });
        
        // ===== THREAD 2: EVEN NUMBERS =====
        Thread evenThread = new Thread(() -> {
            System.out.println("\n🔴 Even Thread Started...");
            for (int i = 2; i <= 10; i += 2) {
                printer.printNumber(i, "Even");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("⚠️ Even thread interrupted!");
                }
            }
            System.out.println("🏁 Even Thread Completed!");
        });
        
        // ===== START THREADS =====
        oddThread.start();
        evenThread.start();
        
        // ===== WAIT FOR THREADS =====
        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println("⚠️ Main thread interrupted!");
        }
        
        System.out.println("\n===========================================");
        System.out.println("   ✅ ALL NUMBERS PRINTED SUCCESSFULLY!");
        System.out.println("   ✅ Odd numbers printed by Odd Thread");
        System.out.println("   ✅ Even numbers printed by Even Thread");
        System.out.println("   ✅ synchronized prevented output mixing");
        System.out.println("===========================================");
    }
}