import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Task 01 - Built-in Exception Handling
 * Demonstrates handling ArithmeticException and InputMismatchException
 */
public class Task01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== DIVISION PROGRAM ===");
        System.out.println("Enter two integers to perform division.\n");
        
        try {
            // Get first number
            System.out.print("Enter first number (dividend): ");
            int num1 = input.nextInt();
            
            // Get second number
            System.out.print("Enter second number (divisor): ");
            int num2 = input.nextInt();
            
            // Perform division
            int result = num1 / num2;
            System.out.println("\n✅ Result: " + num1 + " ÷ " + num2 + " = " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("\n❌ Error: Cannot divide by zero!");
            System.out.println("   Please enter a non-zero divisor.");
            
        } catch (InputMismatchException e) {
            System.out.println("\n❌ Error: Invalid input!");
            System.out.println("   Please enter only integer values.");
            
        } finally {
            System.out.println("\n--- Program execution completed ---");
            input.close();
        }
    }
}