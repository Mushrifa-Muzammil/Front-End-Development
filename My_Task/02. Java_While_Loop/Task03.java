import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number (n): ");
        int n = input.nextInt();
        
        int sum = 0;
        int i = 2;
        
        while (i <= n) {
            sum += i;
            i += 2;  // ✅ Even numbers only!
        }
        
        System.out.println("Sum of even numbers from 1 to " + n + " is: " + sum);
        input.close();
    }
}