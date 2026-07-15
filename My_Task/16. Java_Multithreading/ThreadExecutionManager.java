/**
 * ThreadExecutionManager.java
 * Task 01 - Thread Execution Manager
 * Demonstrates: start(), join(), isAlive(), and synchronized methods
 */

class ThreadManager {
    // Synchronized method to print thread details one at a time
    public synchronized void printThreadDetails(String threadName, int threadId) {
        System.out.println("Thread: " + threadName + " | ID: " + threadId + " | Priority: " + 
                          Thread.currentThread().getPriority() + " | State: " + 
                          Thread.currentThread().getState());
        
        // Simulate some work
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted");
        }
    }
}

class WorkerThread extends Thread {
    private ThreadManager manager;
    private int threadId;
    
    public WorkerThread(ThreadManager manager, String name, int threadId) {
        super(name);
        this.manager = manager;
        this.threadId = threadId;
    }
    
    @Override
    public void run() {
        System.out.println("Thread " + getName() + " started. isAlive: " + isAlive());
        
        // Call synchronized method
        manager.printThreadDetails(getName(), threadId);
        
        System.out.println("Thread " + getName() + " completed. isAlive: " + isAlive());
    }
}

public class ThreadExecutionManager {
    public static void main(String[] args) {
        System.out.println("=== Thread Execution Manager ===");
        System.out.println("Main thread started: " + Thread.currentThread().getName());
        
        // Create thread manager
        ThreadManager manager = new ThreadManager();
        
        // Create 3 threads
        WorkerThread thread1 = new WorkerThread(manager, "Worker-1", 1);
        WorkerThread thread2 = new WorkerThread(manager, "Worker-2", 2);
        WorkerThread thread3 = new WorkerThread(manager, "Worker-3", 3);
        
        // Set priorities (optional)
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        
        // Start threads
        System.out.println("\nStarting threads...");
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Check if threads are alive
        System.out.println("\nThread status before join:");
        System.out.println("Thread-1 isAlive: " + thread1.isAlive());
        System.out.println("Thread-2 isAlive: " + thread2.isAlive());
        System.out.println("Thread-3 isAlive: " + thread3.isAlive());
        
        // Use join() to wait for all threads to complete
        try {
            System.out.println("\nWaiting for threads to complete using join()...");
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        // Check threads status after completion
        System.out.println("\nThread status after join:");
        System.out.println("Thread-1 isAlive: " + thread1.isAlive());
        System.out.println("Thread-2 isAlive: " + thread2.isAlive());
        System.out.println("Thread-3 isAlive: " + thread3.isAlive());
        
        System.out.println("\nAll threads completed execution.");
    }
}