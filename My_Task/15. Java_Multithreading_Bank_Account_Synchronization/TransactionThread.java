/**
 * TransactionThread Class - Implements Runnable
 * Performs multiple deposit and withdrawal transactions
 * Demonstrates thread safety with synchronized methods
 */
public class TransactionThread implements Runnable {
    
    // ===== ATTRIBUTES =====
    private BankAccount account;
    private String threadName;
    private double[] transactions;
    
    // ===== CONSTRUCTOR =====
    public TransactionThread(BankAccount account, String threadName, double[] transactions) {
        this.account = account;
        this.threadName = threadName;
        this.transactions = transactions;
        System.out.println("🧵 " + threadName + " created with " + transactions.length + " transactions.");
    }
    
    // ===== RUN METHOD =====
    @Override
    public void run() {
        System.out.println("\n🚀 " + threadName + " started...");
        
        for (int i = 0; i < transactions.length; i++) {
            double amount = transactions[i];
            
            if (amount > 0) {
                account.deposit(amount, threadName);
            } else {
                account.withdraw(Math.abs(amount), threadName);
            }
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("⚠️ " + threadName + " interrupted!");
            }
        }
        
        System.out.println("\n🏁 " + threadName + " finished transactions.");
    }
}