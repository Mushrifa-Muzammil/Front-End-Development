import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        
        if (age >= 18) {
            System.out.println("You are eligible to vote!");
        } else {
            System.out.println("Sorry! You are not eligible to vote.");
            System.out.println("You need " + (18 - age) + " more years.");
        }
        
        input.close();
    }
}