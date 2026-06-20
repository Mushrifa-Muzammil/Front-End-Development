public class Task02 {
    public static void main(String[] args) {
        System.out.println("Reverse Pattern:");
        
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}