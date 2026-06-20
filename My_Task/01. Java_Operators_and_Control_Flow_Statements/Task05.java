import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        if (number > 0) {
            System.out.println(number + " is POSITIVE");
        } else if (number < 0) {
            System.out.println(number + " is NEGATIVE");
        } else {
            System.out.println("The number is ZERO");
        }
        
        input.close();
    }
}