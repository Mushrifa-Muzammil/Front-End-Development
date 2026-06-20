import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter three numbers:");
        System.out.print("Number 1: ");
        int num1 = input.nextInt();
        
        System.out.print("Number 2: ");
        int num2 = input.nextInt();
        
        System.out.print("Number 3: ");
        int num3 = input.nextInt();
        
        int smallest;
        
        if (num1 <= num2 && num1 <= num3) {
            smallest = num1;
        } else if (num2 <= num1 && num2 <= num3) {
            smallest = num2;
        } else {
            smallest = num3;
        }
        
        System.out.println("The smallest number is: " + smallest);
        input.close();
    }
}