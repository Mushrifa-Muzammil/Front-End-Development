import java.util.Scanner;

// ============================================
// 1. CUSTOM EXCEPTION CLASS
// ============================================
class InsufficientBalanceException extends Exception {
    
    public InsufficientBalanceException(String message) {
        super(message);
        System.out.println("🚨 Custom Exception Created!");
    }
    
    public InsufficientBalanceException() {
        super("Insufficient balance!");
        System.out.println("🚨 Custom Exception Created!");
    }
}

// ============================================
// 2. BANK ACCOUNT CLASS
// ============================================
class BankAccount {
    
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        System.out.println("🏦 Bank Account Created!");
        System.out.println("   Holder: " + accountHolderName);
        System.out.println("   Balance: ₹" + balance);
    }
    
    public void withdraw(double amount) throws InsufficientBalanceException {
        System.out.println("\n--- Withdrawing ₹" + amount + " ---");
        System.out.println("Current Balance: ₹" + balance);
        
        if (amount <= 0) {
            System.out.println("❌ Invalid amount!");
            return;
        }
        
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "❌ Insufficient Balance! Available: ₹" + balance + 
                ", Requested: ₹" + amount
            );
        }
        
        balance = balance - amount;
        System.out.println("✅ Withdrawal Successful!");
        System.out.println("   New Balance: ₹" + balance);
    }
    
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

// ============================================
// 3. MAIN CLASS
// ============================================
public class Task04_BankCustomExceptionProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   CUSTOM EXCEPTION - BANK ACCOUNT");
        System.out.println("========================================\n");
        
        BankAccount account = new BankAccount("ACC1001", "Rahul Sharma", 5000.00);
        account.displayAccountDetails();
        System.out.println();
        
        System.out.print("Enter withdrawal amount: ₹");
        double amount = input.nextDouble();
        System.out.println();
        
        try {
            account.withdraw(amount);
            System.out.println("\n✅ Transaction Successful!");
            account.displayAccountDetails();
            
        } catch (InsufficientBalanceException e) {
            System.out.println("\n❌ " + e.getMessage());
            System.out.println("   Please try with a smaller amount.");
            
        } finally {
            System.out.println("\n📌 Program execution completed");
            input.close();
        }
    }
}