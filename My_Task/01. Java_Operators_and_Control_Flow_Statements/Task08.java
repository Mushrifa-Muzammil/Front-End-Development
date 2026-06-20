import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your marks (0-100): ");
        double marks = input.nextDouble();
        
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Please enter between 0 and 100.");
        } else if (marks >= 90) {
            System.out.println("Grade: A+ (Excellent)");
        } else if (marks >= 80) {
            System.out.println("Grade: A (Very Good)");
        } else if (marks >= 70) {
            System.out.println("Grade: B (Good)");
        } else if (marks >= 60) {
            System.out.println("Grade: C (Average)");
        } else if (marks >= 50) {
            System.out.println("Grade: D (Below Average)");
        } else if (marks >= 40) {
            System.out.println("Grade: E (Just Pass)");
        } else {
            System.out.println("Grade: F (Fail)");
            System.out.println("Need to improve!");
        }
        
        input.close();
    }
}