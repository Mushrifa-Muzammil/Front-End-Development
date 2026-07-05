import java.util.Scanner;

/**
 * BANK ACCOUNT CLASS - Demonstrates Encapsulation
 */
class BankAccount {
    
    // ===== PRIVATE ATTRIBUTES =====
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    
    // ===== CONSTRUCTORS =====
    public BankAccount() {
        accountNumber = "Not Assigned";
        accountHolderName = "Unknown";
        balance = 0.0;
    }
    
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    
    // ===== GETTER AND SETTER METHODS =====
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // ===== DEPOSIT METHOD =====
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("✅ Deposited: ₹" + amount);
            System.out.println("   New Balance: ₹" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }
    
    // ===== WITHDRAW METHOD WITH VALIDATION =====
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance = balance - amount;
                System.out.println("✅ Withdrawn: ₹" + amount);
                System.out.println("   New Balance: ₹" + balance);
            } else {
                System.out.println("❌ Insufficient balance!");
                System.out.println("   Available Balance: ₹" + balance);
            }
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
        }
    }
    
    // ===== DISPLAY METHOD =====
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

/**
 * MAIN CLASS - To Test BankAccount
 */
public class BankAccountProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== BANK ACCOUNT MANAGEMENT SYSTEM ===\n");
        
        // ===== CREATE ACCOUNT =====
        BankAccount account = new BankAccount();
        
        // ===== GET USER INPUT =====
        System.out.println("Enter Account Details:");
        System.out.print("Account Number: ");
        String accNum = input.nextLine();
        System.out.print("Account Holder Name: ");
        String holderName = input.nextLine();
        System.out.print("Initial Balance: ₹");
        double initialBalance = input.nextDouble();
        
        // ===== SET DETAILS =====
        account.setAccountNumber(accNum);
        account.setAccountHolderName(holderName);
        
        System.out.println("\n✅ Account Created Successfully!");
        account.displayAccountDetails();
        System.out.println();
        
        // ===== DEPOSIT =====
        System.out.print("Enter deposit amount: ₹");
        double depositAmount = input.nextDouble();
        account.deposit(depositAmount);
        System.out.println();
        
        // ===== WITHDRAW =====
        System.out.print("Enter withdrawal amount: ₹");
        double withdrawAmount = input.nextDouble();
        account.withdraw(withdrawAmount);
        System.out.println();
        
        // ===== FINAL DETAILS =====
        System.out.println("=== FINAL ACCOUNT STATUS ===");
        account.displayAccountDetails();
        
        input.close();
    }
}