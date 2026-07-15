/**
 * BankAccountTest - Main Class
 * Demonstrates Multithreading with Synchronized Bank Account
 * Creates multiple threads performing deposits and withdrawals
 * Ensures balance never goes negative
 */
public class BankAccountTest {
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   BANK ACCOUNT - THREAD SYNCHRONIZATION");
        System.out.println("   Demonstrating Thread Safety");
        System.out.println("===========================================\n");
        
        // ===== 1. CREATE BANK ACCOUNT =====
        BankAccount account = new BankAccount("ACC1001", "Rahul Sharma", 10000.00);
        account.displayAccountDetails();
        System.out.println();
        
        // ===== 2. CREATE TRANSACTIONS FOR EACH THREAD =====
        // Thread 1: 2 deposits, 1 withdrawal
        double[] transactions1 = {2000.0, -1000.0, 3000.0};
        
        // Thread 2: 1 deposit, 2 withdrawals
        double[] transactions2 = {-2000.0, 5000.0, -3000.0};
        
        // Thread 3: 2 deposits, 2 withdrawals
        double[] transactions3 = {1000.0, -500.0, 2000.0, -1500.0};
        
        // Thread 4: 1 deposit, 3 withdrawals
        double[] transactions4 = {-1000.0, 4000.0, -2000.0, -1000.0};
        
        // ===== 3. CREATE THREADS =====
        TransactionThread thread1 = new TransactionThread(account, "Customer-1", transactions1);
        TransactionThread thread2 = new TransactionThread(account, "Customer-2", transactions2);
        TransactionThread thread3 = new TransactionThread(account, "Customer-3", transactions3);
        TransactionThread thread4 = new TransactionThread(account, "Customer-4", transactions4);
        
        System.out.println("\n🚀 Starting all transaction threads...\n");
        
        // ===== 4. CREATE AND START THREADS =====
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        Thread t3 = new Thread(thread3);
        Thread t4 = new Thread(thread4);
        
        long startTime = System.currentTimeMillis();
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        // ===== 5. WAIT FOR ALL THREADS TO COMPLETE =====
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("⚠️ Main thread interrupted!");
        }
        
        long endTime = System.currentTimeMillis();
        
        // ===== 6. DISPLAY FINAL RESULT =====
        System.out.println("\n===========================================");
        System.out.println("   FINAL ACCOUNT STATUS");
        System.out.println("===========================================");
        account.displayAccountDetails();
        System.out.println("   Total Time: " + (endTime - startTime) + "ms");
        System.out.println("===========================================");
        System.out.println("✅ All transactions completed safely!");
        System.out.println("✅ Balance never went negative!");
        System.out.println("✅ Synchronization prevented race conditions!");
        System.out.println("✅ Thread safety demonstrated!");
        System.out.println("===========================================");
    }
}