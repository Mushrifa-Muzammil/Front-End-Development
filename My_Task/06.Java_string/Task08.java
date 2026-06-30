import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        System.out.print("Original array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        int[] temp = new int[n];
        int newSize = 0;
        
        for (int i = 0; i < n; i++) {
            boolean duplicate = false;
            for (int j = 0; j < newSize; j++) {
                if (arr[i] == temp[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                temp[newSize] = arr[i];
                newSize++;
            }
        }
        
        System.out.print("Array without duplicates: ");
        for (int i = 0; i < newSize; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
        
        input.close();
    }
}