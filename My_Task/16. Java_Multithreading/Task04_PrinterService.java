/**
 * Task 04 - Printer Service
 * Demonstrates: synchronized, setPriority(), join()
 * Multiple employees send print jobs with priority
 */
public class Task04_PrinterService {
    
    // ===== SHARED PRINTER =====
    private static int printCount = 0;
    
    // ===== SYNCHRONIZED PRINT METHOD =====
    public synchronized void printDocument(String employeeName, String documentType, int pages) {
        printCount++;
        System.out.println("\n🖨️ " + employeeName + " - Printing '" + documentType + "'");
        System.out.println("   Pages: " + pages);
        System.out.println("   Print Job #" + printCount);
        
        try {
            // Simulate printing time (50ms per page)
            Thread.sleep(pages * 50);
        } catch (InterruptedException e) {
            System.out.println("⚠️ Print interrupted for " + employeeName);
        }
        
        System.out.println("✅ " + employeeName + " - Print completed!");
    }
    
    public static void main(String[] args) {
        
        System.out.println("===========================================");
        System.out.println("   TASK 04 - PRINTER SERVICE");
        System.out.println("   Multiple Employees with Priority");
        System.out.println("===========================================\n");
        
        Task04_PrinterService printer = new Task04_PrinterService();
        
        // ===== EMPLOYEE DATA =====
        // employeeName, documentType, pages
        String[][] employees = {
            {"Rahul", "Project Report", "5"},
            {"Priya", "Presentation", "3"},
            {"Amit", "Invoice", "2"},
            {"Sneha", "Contract", "8"},
            {"Vikram", "Resume", "4"}
        };
        
        Thread[] threads = new Thread[employees.length];
        
        // ===== CREATE THREADS =====
        System.out.println("📄 Creating " + employees.length + " print jobs...\n");
        
        for (int i = 0; i < employees.length; i++) {
            final String name = employees[i][0];
            final String docType = employees[i][1];
            final int pages = Integer.parseInt(employees[i][2]);
            
            threads[i] = new Thread(() -> {
                printer.printDocument(name, docType, pages);
            });
            threads[i].setName(name);
            
            // ===== SET PRIORITY =====
            // Give higher priority to certain employees
            if (name.equals("Priya") || name.equals("Sneha")) {
                threads[i].setPriority(Thread.MAX_PRIORITY); // Priority 10
                System.out.println("⭐ " + name + " - HIGH PRIORITY");
            } else {
                threads[i].setPriority(Thread.NORM_PRIORITY); // Priority 5
                System.out.println("   " + name + " - Normal Priority");
            }
        }
        
        System.out.println("\n🚀 Starting all print jobs...\n");
        
        // ===== START ALL THREADS =====
        for (Thread t : threads) {
            t.start();
        }
        
        // ===== WAIT FOR ALL THREADS =====
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            System.out.println("⚠️ Main thread interrupted!");
        }
        
        // ===== FINAL RESULT =====
        System.out.println("\n===========================================");
        System.out.println("   ✅ ALL PRINT JOBS COMPLETED!");
        System.out.println("   Total Print Jobs: " + printCount);
        System.out.println("   ✅ synchronized - Print jobs executed one at a time");
        System.out.println("   ✅ setPriority() - Priya and Sneha had high priority");
        System.out.println("   ✅ join() - Main waited for all threads");
        System.out.println("===========================================");
    }
}