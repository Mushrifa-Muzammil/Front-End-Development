/**
 * Task 02 - Bank Account Class
 * Demonstrates Custom Exception in Banking System
 * Attributes: accountNumber, accountHolderName, balance
 */
public class Task02_BankAccount {
    
    // ===== PRIVATE ATTRIBUTES =====
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    
    // ===== CONSTRUCTOR =====
    public Task02_BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        System.out.println("\n🏦 Bank Account Created Successfully!");
        System.out.println("   Account Holder: " + accountHolderName);
        System.out.println("   Account Number: " + accountNumber);
        System.out.println("   Initial Balance: ₹" + balance);
    }
    
    // ===== GETTER METHODS =====
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // ===== WITHDRAW METHOD =====
    public void withdraw(double amount) throws Task01_InsufficientBalanceException {
        
        System.out.println("\n--- Processing Withdrawal ---");
        System.out.println("Requested Amount: ₹" + amount);
        System.out.println("Current Balance: ₹" + balance);
        
        if (amount <= 0) {
            System.out.println("❌ Invalid amount! Please enter a positive value.");
            return;
        }
        
        if (amount > balance) {
            throw new Task01_InsufficientBalanceException(
                "❌ Insufficient Balance! Available: ₹" + balance + 
                ", Requested: ₹" + amount + 
                ", Shortage: ₹" + (amount - balance)
            );
        }
        
        balance = balance - amount;
        System.out.println("✅ Withdrawal Successful!");
        System.out.println("   Amount Withdrawn: ₹" + amount);
        System.out.println("   Remaining Balance: ₹" + balance);
    }
    
    // ===== DISPLAY ACCOUNT DETAILS =====
    public void displayAccountDetails() {
        System.out.println("======================================");
        System.out.println("   ACCOUNT DETAILS");
        System.out.println("======================================");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("======================================");
    }
}