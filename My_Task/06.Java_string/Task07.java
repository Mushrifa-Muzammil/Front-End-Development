import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        System.out.print("Duplicate elements: ");
        boolean found = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                    found = true;
                    break;
                }
            }
        }
        
        if (!found) {
            System.out.println("No duplicates found");
        }
        System.out.println();
        
        input.close();
    }
}