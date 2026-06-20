import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your marks (0-100): ");
        double marks = input.nextDouble();
        
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Please enter between 0 and 100.");
        } else if (marks >= 40) {
            System.out.println("PASS! Congratulations!");
            if (marks >= 75) {
                System.out.println("Excellent performance!");
            }
        } else {
            System.out.println("FAIL! Better luck next time.");
            System.out.println("You need " + (40 - marks) + " more marks to pass.");
        }
        
        input.close();
    }
}