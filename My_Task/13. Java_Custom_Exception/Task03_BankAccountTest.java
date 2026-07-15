import java.util.Scanner;

/**
 * Task 03 - Bank Account Test Class
 * Demonstrates Custom Exception Handling
 * Creates BankAccount and tests withdraw() with try-catch
 */
public class Task03_BankAccountTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("===========================================");
        System.out.println("   BANK ACCOUNT - CUSTOM EXCEPTION DEMO");
        System.out.println("   InsufficientBalanceException");
        System.out.println("===========================================\n");
        
        // ===== CREATE BANK ACCOUNT =====
        Task02_BankAccount account = new Task02_BankAccount("ACC1001", "Rahul Sharma", 5000.00);
        account.displayAccountDetails();
        System.out.println();
        
        // ===== GET WITHDRAWAL AMOUNT =====
        System.out.println("--- Withdrawal Section ---");
        System.out.print("Enter amount to withdraw: ₹");
        double amount = input.nextDouble();
        System.out.println();
        
        // ===== TRY-CATCH FOR CUSTOM EXCEPTION =====
        try {
            account.withdraw(amount);
            System.out.println("\n--- Updated Account Details ---");
            account.displayAccountDetails();
            
        } catch (Task01_InsufficientBalanceException e) {
            System.out.println("\n❌ Transaction Failed!");
            System.out.println("   " + e.getMessage());
            System.out.println("   Please enter an amount within your balance.");
            
        } catch (Exception e) {
            System.out.println("\n❌ Unexpected Error: " + e.getMessage());
            
        } finally {
            System.out.println("\n📌 Transaction completed");
            input.close();
        }
    }
}