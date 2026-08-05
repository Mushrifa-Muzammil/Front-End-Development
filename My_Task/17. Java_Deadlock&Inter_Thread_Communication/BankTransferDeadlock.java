/**
 * Task 03 - Deadlock Version
 * Uses synchronized keyword to lock accounts in different orders.
 */
class BankAccount {
    private int balance;
    private final String accountName;
    
    public BankAccount(String accountName, int initialBalance) {
        this.accountName = accountName;
        this.balance = initialBalance;
    }
    
    public void deposit(int amount) {
        balance += amount;
        System.out.println(accountName + " deposited: " + amount + ", New Balance: " + balance);
    }
    
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountName + " withdrew: " + amount + ", New Balance: " + balance);
            return true;
        } else {
            System.out.println(accountName + " has insufficient balance! Balance: " + balance);
            return false;
        }
    }
    
    public int getBalance() {
        return balance;
    }
    
    public String getAccountName() {
        return accountName;
    }
}

public class BankTransferDeadlock {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("Account A", 1000);
        BankAccount accountB = new BankAccount("Account B", 1000);
        
        // Thread 1: Transfer from A to B
        Thread thread1 = new Thread(() -> {
            synchronized (accountA) {
                System.out.println("Thread1 locked Account A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                synchronized (accountB) {
                    System.out.println("Thread1 locked Account B");
                    if (accountA.withdraw(200)) {
                        accountB.deposit(200);
                    }
                    System.out.println("Thread1 completed transfer from A to B");
                }
            }
        });
        
        // Thread 2: Transfer from B to A (Different lock order)
        Thread thread2 = new Thread(() -> {
            synchronized (accountB) {
                System.out.println("Thread2 locked Account B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                synchronized (accountA) {
                    System.out.println("Thread2 locked Account A");
                    if (accountB.withdraw(300)) {
                        accountA.deposit(300);
                    }
                    System.out.println("Thread2 completed transfer from B to A");
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
}