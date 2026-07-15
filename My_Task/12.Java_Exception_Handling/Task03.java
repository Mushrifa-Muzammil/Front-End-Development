import java.util.Scanner;

/**
 * Task 03 - Throw Keyword
 * Demonstrates explicit exception throwing using throw keyword
 * Throws IllegalArgumentException if age is less than 18
 */
public class Task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== STUDENT AGE VERIFICATION ===");
        System.out.println("Checking if student is eligible (age >= 18)\n");
        
        try {
            System.out.print("Enter student's age: ");
            int age = input.nextInt();
            
            // Check age and throw exception if less than 18
            if (age < 18) {
                throw new IllegalArgumentException(
                    "❌ Age must be 18 or above. Student is not eligible."
                );
            }
            
            System.out.println("✅ Age: " + age + " - Student is eligible!");
            
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("\n❌ Error: Invalid input! Please enter a valid number.");
            
        } finally {
            System.out.println("\n📌 Program execution completed");
            input.close();
        }
    }
}