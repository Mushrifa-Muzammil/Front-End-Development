import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        
        int fact = 1;
        int i = 1;
        
        while (i <= n) {
            fact *= i;
            i++;
        }
        
        System.out.println("Factorial of " + n + " is: " + fact);
        input.close();
    }
}
