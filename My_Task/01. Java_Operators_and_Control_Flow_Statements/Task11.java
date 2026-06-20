import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);
        
        ch = Character.toLowerCase(ch);
        
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println(ch + " is a VOWEL");
            } else {
                System.out.println(ch + " is a CONSONANT");
            }
        } else {
            System.out.println("Invalid input! Please enter an alphabet.");
        }
        
        input.close();
    }
}