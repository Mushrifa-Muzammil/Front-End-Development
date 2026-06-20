import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter day number (1-7): ");
        int day = input.nextInt();
        
        switch (day) {
            case 1:
                System.out.println("Monday - Start of the week!");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday - Midweek!");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday - Weekend is near!");
                break;
            case 6:
                System.out.println("Saturday - Weekend!");
                break;
            case 7:
                System.out.println("Sunday - Holiday!");
                break;
            default:
                System.out.println("Invalid day number! Enter 1-7 only.");
        }
        
        input.close();
    }
}