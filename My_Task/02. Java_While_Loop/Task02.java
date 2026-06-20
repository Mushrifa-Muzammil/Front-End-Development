public class Task02 {
    public static void main(String[] args) {
        System.out.println("Odd numbers from 1 to 50:");
        
        int i = 1;
        while (i <= 50) {
            System.out.print(i + " ");
            i += 2;  // ✅ IMPORTANT: i+2 for odd numbers!
        }
        System.out.println();
    }
}