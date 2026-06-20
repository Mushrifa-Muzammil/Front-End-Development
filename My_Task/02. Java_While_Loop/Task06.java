import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        
        int original = n;
        int count = 0;
        
        if (n == 0) {
            count = 1;
        } else {
            while (n > 0) {
                count++;
                n = n / 10;
            }
        }
        
        System.out.println("Number of digits in " + original + " is: " + count);
        input.close();
    }
}
