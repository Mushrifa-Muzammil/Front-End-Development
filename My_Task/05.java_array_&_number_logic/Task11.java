import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        
        int original = n;
        int sum = 0;
        
        while (n > 0) {
            int digit = n % 10;
            sum = sum + (digit * digit * digit);
            n = n / 10;
        }
        
        if (original == sum) {
            System.out.println(original + " is an ARMSTRONG number");
        } else {
            System.out.println(original + " is NOT an Armstrong number");
        }
        
        input.close();
    }
}