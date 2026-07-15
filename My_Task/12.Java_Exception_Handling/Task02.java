import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Task 02 - Finally Block
 * Demonstrates the use of finally block
 * The message "Program execution completed" always displays
 */
public class Task02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== DIVISION WITH FINALLY BLOCK ===");
        System.out.println("Enter two integers to perform division.\n");
        
        try {
            System.out.print("Enter first number (dividend): ");
            int num1 = input.nextInt();
            
            System.out.print("Enter second number (divisor): ");
            int num2 = input.nextInt();
            
            int result = num1 / num2;
            System.out.println("\n✅ Result: " + num1 + " ÷ " + num2 + " = " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("\n❌ Error: Cannot divide by zero!");
            
        } catch (InputMismatchException e) {
            System.out.println("\n❌ Error: Invalid input! Please enter integers only.");
            input.nextLine(); // Clear the invalid input
            
        } finally {
            // ✅ This always executes - whether exception occurs or not
            System.out.println("\n📌 Program execution completed");
            input.close();
        }
    }
}