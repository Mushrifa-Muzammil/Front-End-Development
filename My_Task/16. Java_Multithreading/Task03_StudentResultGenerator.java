/**
 * Task 03 - Student Result Generator
 * Demonstrates: synchronized, isAlive()
 * Multiple threads calculate marks for different students
 */
public class Task03_StudentResultGenerator {
    
    // ===== SHARED REPORT =====
    private static String sharedReport = "";
    
    // ===== SYNCHRONIZED METHOD TO WRITE RESULT =====
    public synchronized void writeResult(String studentName, int marks) {
        String result = studentName + " ➜ Marks: " + marks + " ➜ " + 
                       (marks >= 40 ? "PASS ✅" : "FAIL ❌");
        sharedReport = sharedReport + result + "\n";
        System.out.println("📝 " + result);
        
        try {
            Thread.sleep(200); // Simulate writing time
        } catch (InterruptedException e) {
            System.out.println("⚠️ Thread interrupted!");
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   TASK 03 - STUDENT RESULT GENERATOR");
        System.out.println("   Multiple Threads Calculating Results");
        System.out.println("===========================================\n");
        
        Task03_StudentResultGenerator generator = new Task03_StudentResultGenerator();
        
        // ===== STUDENT DATA =====
        String[][] students = {
            {"Rahul", "85"},
            {"Priya", "92"},
            {"Amit", "38"},
            {"Sneha", "76"},
            {"Vikram", "45"},
            {"Anjali", "55"}
        };
        
        Thread[] threads = new Thread[students.length];
        
        // ===== CREATE THREADS FOR EACH STUDENT =====
        System.out.println("🚀 Calculating results for " + students.length + " students...\n");
        
        for (int i = 0; i < students.length; i++) {
            final String name = students[i][0];
            final int marks = Integer.parseInt(students[i][1]);
            
            threads[i] = new Thread(() -> {
                generator.writeResult(name, marks);
            });
            threads[i].setName(name);
        }
        
        // ===== START ALL THREADS =====
        for (Thread t : threads) {
            t.start();
        }
        
        // ===== CHECK isAlive() DURING EXECUTION =====
        System.out.println("\n📊 Thread Status During Execution:");
        for (int i = 0; i < threads.length; i++) {
            System.out.println("  " + students[i][0] + " isAlive: " + threads[i].isAlive());
        }
        
        // ===== WAIT FOR ALL THREADS =====
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            System.out.println("⚠️ Main thread interrupted!");
        }
        
        // ===== CHECK isAlive() AFTER COMPLETION =====
        System.out.println("\n📊 Thread Status After Completion:");
        for (int i = 0; i < threads.length; i++) {
            System.out.println("  " + students[i][0] + " isAlive: " + threads[i].isAlive());
        }
        
        // ===== DISPLAY FINAL REPORT =====
        System.out.println("\n===========================================");
        System.out.println("   FINAL RESULT REPORT");
        System.out.println("===========================================");
        System.out.print(sharedReport);
        System.out.println("===========================================");
        System.out.println("✅ All student results calculated!");
        System.out.println("✅ synchronized prevented data corruption!");
        System.out.println("✅ isAlive() used to check thread status!");
        System.out.println("===========================================");
    }
}