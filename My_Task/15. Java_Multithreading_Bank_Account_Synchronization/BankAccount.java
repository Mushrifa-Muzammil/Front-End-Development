/**
 * BankAccount Class - Demonstrates Thread Synchronization
 * deposit() and withdraw() methods are synchronized
 * Prevents race conditions and negative balance
 */
public class BankAccount {
    
    // ===== ATTRIBUTES =====
    private double balance;
    private String accountNumber;
    private String accountHolderName;
    
    // ===== CONSTRUCTOR =====
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        System.out.println("🏦 Bank Account Created Successfully!");
        System.out.println("   Account Number: " + accountNumber);
        System.out.println("   Account Holder: " + accountHolderName);
        System.out.println("   Initial Balance: ₹" + balance);
        System.out.println("===========================================");
    }
    
    // ===== SYNCHRONIZED DEPOSIT METHOD =====
    public synchronized void deposit(double amount, String threadName) {
        System.out.println("\n💰 " + threadName + " - DEPOSITING ₹" + amount);
        System.out.println("   Current Balance: ₹" + balance);
        
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("✅ " + threadName + " - Deposit Successful!");
            System.out.println("   New Balance: ₹" + balance);
        } else {
            System.out.println("❌ " + threadName + " - Invalid deposit amount!");
        }
    }
    
    // ===== SYNCHRONIZED WITHDRAW METHOD =====
    public synchronized void withdraw(double amount, String threadName) {
        System.out.println("\n🏧 " + threadName + " - WITHDRAWING ₹" + amount);
        System.out.println("   Current Balance: ₹" + balance);
        
        if (amount <= 0) {
            System.out.println("❌ " + threadName + " - Invalid withdrawal amount!");
            return;
        }
        
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("✅ " + threadName + " - Withdrawal Successful!");
            System.out.println("   New Balance: ₹" + balance);
        } else {
            System.out.println("❌ " + threadName + " - Insufficient Balance!");
            System.out.println("   Available: ₹" + balance + ", Requested: ₹" + amount);
            System.out.println("   ❌ Balance never went negative - synchronized worked!");
        }
    }
    
    // ===== GETTER METHODS =====
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    // ===== DISPLAY ACCOUNT DETAILS =====
    public void displayAccountDetails() {
        System.out.println("===========================================");
        System.out.println("   ACCOUNT DETAILS");
        System.out.println("===========================================");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("===========================================");
    }
}