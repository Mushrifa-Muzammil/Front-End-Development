/**
 * JAVA MULTITHREADING - ALL TASKS IN ONE FILE
 * Task 01: Thread Execution Manager
 * Task 02: Number Printer
 * Task 03: Student Result Generator
 * Task 04: Printer Service
 */

// ============================================
// TASK 01: THREAD EXECUTION MANAGER
// ============================================
class ThreadExecutionManager {
    
    public synchronized void printThreadDetails(String threadName, int threadId) {
        System.out.println("\n📌 " + threadName + " executing...");
        System.out.println("   Thread ID: " + threadId);
        System.out.println("   Is Alive? " + Thread.currentThread().isAlive());
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        System.out.println("✅ " + threadName + " completed!");
    }
    
    public void execute() {
        System.out.println("\n=== TASK 01: Thread Execution Manager ===");
        ThreadExecutionManager manager = this;
        
        Thread t1 = new Thread(() -> manager.printThreadDetails("Thread-1", 1));
        Thread t2 = new Thread(() -> manager.printThreadDetails("Thread-2", 2));
        Thread t3 = new Thread(() -> manager.printThreadDetails("Thread-3", 3));
        
        t1.start(); t2.start(); t3.start();
        
        try { t1.join(); t2.join(); t3.join(); } catch (InterruptedException e) {}
        System.out.println("✅ All threads completed!");
    }
}

// ============================================
// TASK 02: NUMBER PRINTER
// ============================================
class NumberPrinter {
    
    public synchronized void printNumber(int number, String threadName) {
        System.out.println(threadName + " ➜ " + number);
        try { Thread.sleep(100); } catch (InterruptedException e) {}
    }
    
    public void execute() {
        System.out.println("\n=== TASK 02: Number Printer ===");
        NumberPrinter printer = this;
        
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                printer.printNumber(i, "Odd");
            }
        });
        
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                printer.printNumber(i, "Even");
            }
        });
        
        oddThread.start();
        evenThread.start();
        
        try { oddThread.join(); evenThread.join(); } catch (InterruptedException e) {}
        System.out.println("✅ All numbers printed!");
    }
}

// ============================================
// TASK 03: STUDENT RESULT GENERATOR
// ============================================
class StudentResultGenerator {
    private String sharedReport = "";
    
    public synchronized void writeResult(String studentName, int marks) {
        String result = studentName + " ➜ Marks: " + marks + " ➜ " + 
                       (marks >= 40 ? "PASS ✅" : "FAIL ❌");
        sharedReport += result + "\n";
        System.out.println(result);
        try { Thread.sleep(200); } catch (InterruptedException e) {}
    }
    
    public void execute() {
        System.out.println("\n=== TASK 03: Student Result Generator ===");
        StudentResultGenerator generator = this;
        
        String[][] students = {{"Rahul","85"}, {"Priya","92"}, {"Amit","38"}, {"Sneha","76"}};
        Thread[] threads = new Thread[students.length];
        
        for (int i = 0; i < students.length; i++) {
            final String name = students[i][0];
            final int marks = Integer.parseInt(students[i][1]);
            threads[i] = new Thread(() -> generator.writeResult(name, marks));
        }
        
        for (Thread t : threads) t.start();
        for (Thread t : threads) { try { t.join(); } catch (InterruptedException e) {} }
        
        System.out.println("\nFinal Report:\n" + sharedReport);
        System.out.println("✅ All results calculated!");
    }
}

// ============================================
// TASK 04: PRINTER SERVICE
// ============================================
class PrinterService {
    private static int printCount = 0;
    
    public synchronized void printDocument(String employeeName, String documentType, int pages) {
        printCount++;
        System.out.println("\n🖨️ " + employeeName + " - Printing '" + documentType + "' (" + pages + " pages)");
        try { Thread.sleep(pages * 50); } catch (InterruptedException e) {}
        System.out.println("✅ " + employeeName + " - Print completed!");
    }
    
    public void execute() {
        System.out.println("\n=== TASK 04: Printer Service ===");
        PrinterService printer = this;
        
        String[][] employees = {{"Rahul","Report","5"}, {"Priya","Presentation","3"}, 
                               {"Amit","Invoice","2"}, {"Sneha","Contract","8"}};
        Thread[] threads = new Thread[employees.length];
        
        for (int i = 0; i < employees.length; i++) {
            final String name = employees[i][0];
            final String doc = employees[i][1];
            final int pages = Integer.parseInt(employees[i][2]);
            
            threads[i] = new Thread(() -> printer.printDocument(name, doc, pages));
            threads[i].setName(name);
            
            if (name.equals("Priya") || name.equals("Sneha")) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
                System.out.println("⭐ " + name + " - HIGH PRIORITY");
            } else {
                System.out.println("   " + name + " - Normal Priority");
            }
        }
        
        for (Thread t : threads) t.start();
        for (Thread t : threads) { try { t.join(); } catch (InterruptedException e) {} }
        
        System.out.println("\n✅ All " + printCount + " print jobs completed!");
    }
}

// ============================================
// MAIN CLASS
// ============================================
public class MultithreadingTasksProgram {
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   JAVA MULTITHREADING - ALL TASKS");
        System.out.println("===========================================");
        
        // Execute all tasks
        new ThreadExecutionManager().execute();
        new NumberPrinter().execute();
        new StudentResultGenerator().execute();
        new PrinterService().execute();
        
        System.out.println("\n===========================================");
        System.out.println("   ✅ ALL TASKS COMPLETED SUCCESSFULLY!");
        System.out.println("===========================================");
    }
}