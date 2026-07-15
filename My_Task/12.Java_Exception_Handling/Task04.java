import java.util.Scanner;

/**
 * Task 04 - Throw and Throws
 * Demonstrates the use of throw and throws keywords
 * Method declares throws Exception and throws exception for negative numbers
 */
public class Task04 {
    
    /**
     * Method to check if a number is positive
     * Uses throws Exception in declaration
     * Throws exception if number is negative
     */
    public static void checkPositive(int number) throws Exception {
        if (number < 0) {
            throw new Exception("❌ Negative numbers are not allowed! Please enter a positive number.");
        } else if (number == 0) {
            System.out.println("⚠️ Number is zero (neutral)");
        } else {
            System.out.println("✅ Number is POSITIVE!");
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== POSITIVE NUMBER CHECKER ===");
        System.out.println("Using throw and throws keywords\n");
        
        try {
            System.out.print("Enter a number: ");
            int number = input.nextInt();
            
            // Call method that throws exception
            checkPositive(number);
            
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
            System.out.println("   Please try again with a non-negative number.");
            
        } finally {
            System.out.println("\n📌 Program execution completed");
            input.close();
        }
    }
}