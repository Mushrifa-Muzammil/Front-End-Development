/**
 * Task 02 - Deadlock Version
 * Demonstrates deadlock by locking accounts in different orders.
 */
class Account {
    private int balance;
    private final int accountNumber;
    
    public Account(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Account " + accountNumber + " deposited: " + amount + 
                          ", New Balance: " + balance);
    }
    
    public void withdraw(int amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance in Account " + 
                                                  accountNumber + ". Balance: " + balance);
        }
        balance -= amount;
        System.out.println("Account " + accountNumber + " withdrew: " + amount + 
                          ", New Balance: " + balance);
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccountDeadlock {
    public static void main(String[] args) {
        Account accountA = new Account(1, 1000);
        Account accountB = new Account(2, 1000);
        
        // Thread 1: Transfer from A to B
        Thread thread1 = new Thread(() -> {
            synchronized (accountA) {
                System.out.println("Thread1 locked Account A");
                try {
                    Thread.sleep(100); // Delay to increase deadlock chance
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                synchronized (accountB) {
                    System.out.println("Thread1 locked Account B");
                    try {
                        accountA.withdraw(200);
                        accountB.deposit(200);
                        System.out.println("Transfer 200 from Account A to Account B completed");
                    } catch (InsufficientBalanceException e) {
                        System.out.println("Transfer failed: " + e.getMessage());
                    }
                }
            }
        });
        
        // Thread 2: Transfer from B to A (Locking in different order)
        Thread thread2 = new Thread(() -> {
            synchronized (accountB) {
                System.out.println("Thread2 locked Account B");
                try {
                    Thread.sleep(100); // Delay to increase deadlock chance
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                synchronized (accountA) {
                    System.out.println("Thread2 locked Account A");
                    try {
                        accountB.withdraw(300);
                        accountA.deposit(300);
                        System.out.println("Transfer 300 from Account B to Account A completed");
                    } catch (InsufficientBalanceException e) {
                        System.out.println("Transfer failed: " + e.getMessage());
                    }
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
}