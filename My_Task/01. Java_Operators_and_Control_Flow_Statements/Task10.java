import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("--- SIMPLE CALCULATOR ---");
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        
        System.out.println("\nChoose operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (×)");
        System.out.println("4. Division (÷)");
        System.out.print("Enter your choice (1-4): ");
        int choice = input.nextInt();
        
        double result = 0;
        boolean validOperation = true;
        
        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println(num1 + " × " + num2 + " = " + result);
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println(num1 + " ÷ " + num2 + " = " + result);
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Invalid choice! Please select 1-4.");
                validOperation = false;
        }
        
        if (validOperation && choice >= 1 && choice <= 4) {
            System.out.println("Result: " + result);
        }
        
        input.close();
    }
}