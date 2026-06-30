import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        int evenCount = 0;
        int oddCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
        input.close();
    }
}