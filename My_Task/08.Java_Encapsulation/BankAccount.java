/**
 * BankAccount Class - Demonstrates Encapsulation in Java
 * All attributes are private and accessed via public methods
 */
public class BankAccount {
    
    // ===== PRIVATE ATTRIBUTES (Encapsulation) =====
    private String accountNumber;      // Account number
    private String accountHolderName;  // Account holder name
    private double balance;            // Account balance
    
    // ===== DEFAULT CONSTRUCTOR =====
    public BankAccount() {
        accountNumber = "Not Assigned";
        accountHolderName = "Unknown";
        balance = 0.0;
        System.out.println("Default Constructor Called!");
    }
    
    // ===== PARAMETERIZED CONSTRUCTOR =====
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        System.out.println("Parameterized Constructor Called!");
    }
    
    // ===== GETTER AND SETTER METHODS =====
    
    // Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }
    
    // Setter for accountNumber
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    // Getter for accountHolderName
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    // Setter for accountHolderName
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    
    // Getter for balance
    public double getBalance() {
        return balance;
    }
    
    // ===== DEPOSIT METHOD =====
    // Adds money to the balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("✅ Deposited: ₹" + amount);
            System.out.println("   New Balance: ₹" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount! Amount must be positive.");
        }
    }
    
    // ===== WITHDRAW METHOD =====
    // Subtracts money from the balance only if sufficient funds are available
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance = balance - amount;
                System.out.println("✅ Withdrawn: ₹" + amount);
                System.out.println("   New Balance: ₹" + balance);
            } else {
                System.out.println("❌ Insufficient balance!");
                System.out.println("   Available Balance: ₹" + balance);
                System.out.println("   Requested Amount: ₹" + amount);
            }
        } else {
            System.out.println("❌ Invalid withdrawal amount! Amount must be positive.");
        }
    }
    
    // ===== DISPLAY ACCOUNT DETAILS METHOD =====
    public void displayAccountDetails() {
        System.out.println("==============================");
        System.out.println("   ACCOUNT DETAILS");
        System.out.println("==============================");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
        System.out.println("==============================");
    }
}