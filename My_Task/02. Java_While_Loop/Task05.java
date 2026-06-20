import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        
        int original = n;
        int reverse = 0;
        
        while (n > 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }
        
        System.out.println("Original number: " + original);
        System.out.println("Reversed number: " + reverse);
        
        input.close();
    }
}