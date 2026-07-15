/**
 * PrinterService.java
 * Task 04 - Printer Service
 * Demonstrates: synchronized, setPriority(), join()
 */

class PrintDocument {
    private String documentName;
    private int pageCount;
    private String employeeName;
    
    public PrintDocument(String documentName, int pageCount, String employeeName) {
        this.documentName = documentName;
        this.pageCount = pageCount;
        this.employeeName = employeeName;
    }
    
    public String getDocumentName() { return documentName; }
    public int getPageCount() { return pageCount; }
    public String getEmployeeName() { return employeeName; }
    
    @Override
    public String toString() {
        return "Document: " + documentName + 
               " | Pages: " + pageCount + 
               " | Employee: " + employeeName;
    }
}

class Printer {
    private int printedJobs = 0;
    private int totalPagesPrinted = 0;
    
    // Synchronized method to handle print jobs
    public synchronized void printDocument(PrintDocument document) {
        System.out.println("=== PRINT JOB STARTED ===");
        System.out.println("Printer is processing: " + document);
        System.out.println("Printing by thread: " + Thread.currentThread().getName());
        System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
        
        try {
            // Simulate printing time based on pages
            int printTime = document.getPageCount() * 200; // 200ms per page
            System.out.println("Estimated print time: " + printTime + "ms");
            
            // Print process simulation
            for (int i = 1; i <= document.getPageCount(); i++) {
                Thread.sleep(200);
                System.out.println("Printing page " + i + " of " + document.getPageCount() + 
                                 " for " + document.getDocumentName());
            }
            
            printedJobs++;
            totalPagesPrinted += document.getPageCount();
            
            System.out.println("Print job completed: " + document.getDocumentName());
            System.out.println("================================\n");
            
        } catch (InterruptedException e) {
            System.out.println("Print job interrupted: " + document.getDocumentName());
        }
    }
    
    public synchronized void printSummary() {
        System.out.println("\n=== PRINTER SUMMARY ===");
        System.out.println("Total print jobs: " + printedJobs);
        System.out.println("Total pages printed: " + totalPagesPrinted);
        System.out.println("=======================\n");
    }
}

class EmployeeThread extends Thread {
    private Printer printer;
    private PrintDocument document;
    
    public EmployeeThread(Printer printer, PrintDocument document, String threadName) {
        super(threadName);
        this.printer = printer;
        this.document = document;
    }
    
    @Override
    public void run() {
        System.out.println("Employee thread " + getName() + " started. isAlive: " + isAlive());
        System.out.println("Priority set to: " + getPriority());
        
        // Send print job to printer
        printer.printDocument(document);
        
        System.out.println("Employee thread " + getName() + " completed. isAlive: " + isAlive());
    }
}

public class PrinterService {
    public static void main(String[] args) {
        System.out.println("=== Printer Service ===");
        
        // Create printer
        Printer printer = new Printer();
        
        // Create print jobs for employees
        PrintDocument[] documents = {
            new PrintDocument("Annual_Report_2025.pdf", 20, "John Doe"),
            new PrintDocument("Project_Proposal.docx", 10, "Jane Smith"),
            new PrintDocument("Marketing_Plan.pptx", 15, "Bob Johnson"),
            new PrintDocument("Budget_Spreadsheet.xlsx", 30, "Alice Williams"),
            new PrintDocument("Meeting_Minutes.docx", 5, "Charlie Davis")
        };
        
        // Create employee threads
        EmployeeThread[] employees = new EmployeeThread[documents.length];
        
        for (int i = 0; i < documents.length; i++) {
            employees[i] = new EmployeeThread(printer, documents[i], 
                                             "Employee-" + (i + 1));
            
            // Set priorities - give one employee higher priority
            if (i == 2) { // Bob Johnson gets highest priority
                employees[i].setPriority(Thread.MAX_PRIORITY);
                System.out.println("Setting HIGH priority to " + employees[i].getName());
            } else {
                employees[i].setPriority(Thread.NORM_PRIORITY);
            }
        }
        
        // Start all employee threads
        System.out.println("\nStarting all employee threads...\n");
        for (EmployeeThread employee : employees) {
            employee.start();
        }
        
        // Use join() to wait for all print jobs to complete
        System.out.println("\nWaiting for all print jobs to complete...\n");
        for (int i = 0; i < employees.length; i++) {
            try {
                employees[i].join();
                System.out.println("Employee-" + (i + 1) + " print job completed");
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting for Employee-" + (i + 1));
            }
        }
        
        // Print summary
        printer.printSummary();
        
        System.out.println("All print jobs completed successfully.");
    }
}