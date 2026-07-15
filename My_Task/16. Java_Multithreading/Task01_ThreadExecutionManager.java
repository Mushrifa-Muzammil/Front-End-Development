/**
 * Task 01 - Thread Execution Manager
 * Demonstrates: start(), join(), isAlive(), synchronized
 * Creates 3 threads and manages their execution
 */
public class Task01_ThreadExecutionManager {
    
    // ===== SYNCHRONIZED METHOD =====
    // Only one thread can execute this at a time
    public synchronized void printThreadDetails(String threadName, int threadId) {
        System.out.println("\n📌 " + threadName + " is executing...");
        System.out.println("   Thread ID: " + threadId);
        System.out.println("   Is Alive? " + Thread.currentThread().isAlive());
        System.out.println("   Priority: " + Thread.currentThread().getPriority());
        
        // Simulate work
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("⚠️ Thread interrupted!");
        }
        
        System.out.println("✅ " + threadName + " completed execution!");
    }
    
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   TASK 01 - THREAD EXECUTION MANAGER");
        System.out.println("   Demonstrating start(), join(), isAlive()");
        System.out.println("===========================================\n");
        
        // Create object for synchronized method
        Task01_ThreadExecutionManager manager = new Task01_ThreadExecutionManager();
        
        // ===== CREATE 3 THREADS =====
        Thread t1 = new Thread(() -> {
            manager.printThreadDetails("Thread-1", 1);
        });
        
        Thread t2 = new Thread(() -> {
            manager.printThreadDetails("Thread-2", 2);
        });
        
        Thread t3 = new Thread(() -> {
            manager.printThreadDetails("Thread-3", 3);
        });
        
        // ===== SET THREAD NAMES =====
        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");
        
        System.out.println("🚀 Starting all threads...\n");
        
        // ===== START ALL THREADS =====
        t1.start();
        t2.start();
        t3.start();
        
        // ===== CHECK isAlive() BEFORE JOIN =====
        System.out.println("\n📊 Thread Status Before Join:");
        System.out.println("Thread-1 isAlive: " + t1.isAlive());
        System.out.println("Thread-2 isAlive: " + t2.isAlive());
        System.out.println("Thread-3 isAlive: " + t3.isAlive());
        
        // ===== USE join() TO WAIT FOR THREADS =====
        try {
            System.out.println("\n⏳ Waiting for threads to complete using join()...");
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("⚠️ Main thread interrupted!");
        }
        
        // ===== CHECK isAlive() AFTER JOIN =====
        System.out.println("\n📊 Thread Status After Join:");
        System.out.println("Thread-1 isAlive: " + t1.isAlive());
        System.out.println("Thread-2 isAlive: " + t2.isAlive());
        System.out.println("Thread-3 isAlive: " + t3.isAlive());
        
        // ===== FINAL RESULT =====
        System.out.println("\n===========================================");
        System.out.println("   ✅ ALL THREADS EXECUTED SUCCESSFULLY!");
        System.out.println("   ✅ start() - Threads started");
        System.out.println("   ✅ join() - Main waited for threads");
        System.out.println("   ✅ isAlive() - Thread status checked");
        System.out.println("   ✅ synchronized - Method executed one at a time");
        System.out.println("===========================================");
    }
}