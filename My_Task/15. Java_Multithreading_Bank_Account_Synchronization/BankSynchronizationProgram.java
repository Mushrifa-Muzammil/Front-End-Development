/**
 * BANK ACCOUNT SYNCHRONIZATION - Single File Program
 * Demonstrates Multithreading with Synchronized Methods
 */

// ============================================
// 1. BANK ACCOUNT CLASS
// ============================================
class BankAccount {
    private double balance;
    private String accountNumber;
    private String accountHolderName;
    
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        System.out.println("🏦 Bank Account Created!");
        System.out.println("   Holder: " + accountHolderName);
        System.out.println("   Balance: ₹" + balance);
    }
    
    public synchronized void deposit(double amount, String threadName) {
        System.out.println("\n💰 " + threadName + " - Depositing ₹" + amount);
        System.out.println("   Current Balance: ₹" + balance);
        
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("✅ Deposit Successful! New Balance: ₹" + balance);
        } else {
            System.out.println("❌ Invalid amount!");
        }
    }
    
    public synchronized void withdraw(double amount, String threadName) {
        System.out.println("\n🏧 " + threadName + " - Withdrawing ₹" + amount);
        System.out.println("   Current Balance: ₹" + balance);
        
        if (amount <= 0) {
            System.out.println("❌ Invalid amount!");
            return;
        }
        
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("✅ Withdrawal Successful! New Balance: ₹" + balance);
        } else {
            System.out.println("❌ Insufficient Balance!");
            System.out.println("   Available: ₹" + balance + ", Requested: ₹" + amount);
        }
    }
    
    public double getBalance() { return balance; }
}

// ============================================
// 2. TRANSACTION THREAD
// ============================================
class TransactionThread implements Runnable {
    private BankAccount account;
    private String threadName;
    private double[] transactions;
    
    public TransactionThread(BankAccount account, String threadName, double[] transactions) {
        this.account = account;
        this.threadName = threadName;
        this.transactions = transactions;
    }
    
    @Override
    public void run() {
        for (double amount : transactions) {
            if (amount > 0) {
                account.deposit(amount, threadName);
            } else {
                account.withdraw(Math.abs(amount), threadName);
            }
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }
        System.out.println("🏁 " + threadName + " completed!");
    }
}

// ============================================
// 3. MAIN CLASS
// ============================================
public class BankSynchronizationProgram {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   BANK ACCOUNT SYNCHRONIZATION");
        System.out.println("========================================\n");
        
        // Create Account
        BankAccount account = new BankAccount("ACC1001", "Rahul Sharma", 10000.00);
        System.out.println();
        
        // Create transactions for each thread
        double[] t1 = {2000, -1000, 3000};
        double[] t2 = {-2000, 5000, -3000};
        double[] t3 = {1000, -500, 2000, -1500};
        double[] t4 = {-1000, 4000, -2000, -1000};
        
        // Create threads
        Thread th1 = new Thread(new TransactionThread(account, "Customer-1", t1));
        Thread th2 = new Thread(new TransactionThread(account, "Customer-2", t2));
        Thread th3 = new Thread(new TransactionThread(account, "Customer-3", t3));
        Thread th4 = new Thread(new TransactionThread(account, "Customer-4", t4));
        
        System.out.println("🚀 Starting all threads...\n");
        
        // Start threads
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        
        // Wait for all threads
        try {
            th1.join(); th2.join(); th3.join(); th4.join();
        } catch (InterruptedException e) {}
        
        // Final Result
        System.out.println("\n========================================");
        System.out.println("   FINAL RESULT");
        System.out.println("========================================");
        System.out.println("Final Balance: ₹" + account.getBalance());
        System.out.println("✅ All transactions completed safely!");
        System.out.println("✅ Balance never went negative!");
        System.out.println("✅ Synchronization prevented race conditions!");
        System.out.println("========================================");
    }
}