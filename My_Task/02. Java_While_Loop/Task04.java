import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        
        System.out.println("\nMultiplication Table of " + num + ":");
        int i = 1;
        while (i <= 10) {
            System.out.println(num + " × " + i + " = " + (num * i));
            i++;
        }
        
        input.close();
    }
}