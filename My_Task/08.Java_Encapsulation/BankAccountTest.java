/**
 * BankAccountTest Class - Tests the BankAccount class
 * Demonstrates encapsulation, deposit, and withdrawal operations
 */
public class BankAccountTest {
    public static void main(String[] args) {
        
        System.out.println("=== BANK ACCOUNT MANAGEMENT SYSTEM ===\n");
        
        // ===== 1. CREATE BANK ACCOUNT OBJECT =====
        System.out.println("1. Creating Bank Account:");
        BankAccount account = new BankAccount();
        account.displayAccountDetails();
        System.out.println();
        
        // ===== 2. SET ACCOUNT DETAILS USING SETTER METHODS =====
        System.out.println("2. Setting Account Details:");
        account.setAccountNumber("ACC1001");
        account.setAccountHolderName("Raj Kumar");
        System.out.println("✅ Account details updated successfully!");
        account.displayAccountDetails();
        System.out.println();
        
        // ===== 3. DEPOSIT ₹5000 =====
        System.out.println("3. Deposit ₹5000:");
        account.deposit(5000);
        System.out.println();
        
        // ===== 4. WITHDRAW ₹2000 =====
        System.out.println("4. Withdraw ₹2000:");
        account.withdraw(2000);
        System.out.println();
        
        // ===== 5. DISPLAY UPDATED ACCOUNT DETAILS =====
        System.out.println("5. Updated Account Details:");
        account.displayAccountDetails();
        System.out.println();
        
        // ===== 6. EXTRA: Test Invalid Withdrawal =====
        System.out.println("6. Testing Insufficient Balance:");
        account.withdraw(10000);
        System.out.println();
        
        // ===== 7. FINAL ACCOUNT STATUS =====
        System.out.println("=== FINAL ACCOUNT STATUS ===");
        account.displayAccountDetails();
    }
}