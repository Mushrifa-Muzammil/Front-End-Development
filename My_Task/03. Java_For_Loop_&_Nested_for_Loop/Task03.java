public class Task03 {
    public static void main(String[] args) {
        System.out.println("Number Pattern:");
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}