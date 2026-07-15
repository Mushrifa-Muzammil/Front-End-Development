/**
 * Task 01 - Custom Exception Class
 * InsufficientBalanceException - User-defined exception
 * Thrown when withdrawal amount exceeds available balance
 */
public class Task01_InsufficientBalanceException extends Exception {
    
    // Constructor with custom message
    public Task01_InsufficientBalanceException(String message) {
        super(message);
        System.out.println("🚨 Custom Exception Created: InsufficientBalanceException");
    }
    
    // Constructor with default message
    public Task01_InsufficientBalanceException() {
        super("Insufficient balance! Cannot withdraw more than available balance.");
        System.out.println("🚨 Custom Exception Created: InsufficientBalanceException");
    }
}