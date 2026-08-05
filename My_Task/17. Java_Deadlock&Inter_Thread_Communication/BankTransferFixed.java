/**
 * Task 03 - Fixed Version
 * Prevents deadlock using consistent lock ordering (alphabetical order).
 */
class BankAccountFixed {
    private int balance;
    private final String accountName;
    
    public BankAccountFixed(String accountName, int initialBalance) {
        this.accountName = accountName;
        this.balance = initialBalance;
    }
    
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(accountName + " deposited: " + amount + ", New Balance: " + balance);
    }
    
    public synchronized boolean withdraw(int amount) {
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

public class BankTransferFixed {
    
    // Helper method for consistent locking order
    private static void transfer(BankAccountFixed from, BankAccountFixed to, int amount) {
        // Get locks in alphabetical order (consistent)
        BankAccountFixed firstLock, secondLock;
        if (from.getAccountName().compareTo(to.getAccountName()) < 0) {
            firstLock = from;
            secondLock = to;
        } else {
            firstLock = to;
            secondLock = from;
        }
        
        synchronized (firstLock) {
            System.out.println("Locked: " + firstLock.getAccountName());
            synchronized (secondLock) {
                System.out.println("Locked: " + secondLock.getAccountName());
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                    System.out.println("Transfer " + amount + " from " + from.getAccountName() + 
                                      " to " + to.getAccountName() + " completed");
                } else {
                    System.out.println("Transfer from " + from.getAccountName() + 
                                      " to " + to.getAccountName() + " failed");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BankAccountFixed accountA = new BankAccountFixed("Account A", 1000);
        BankAccountFixed accountB = new BankAccountFixed("Account B", 1000);
        
        // Thread 1: Transfer from A to B
        Thread thread1 = new Thread(() -> {
            transfer(accountA, accountB, 200);
        });
        
        // Thread 2: Transfer from B to A (Will use consistent locking)
        Thread thread2 = new Thread(() -> {
            transfer(accountB, accountA, 300);
        });
        
        thread1.start();
        thread2.start();
    }
}