/**
 * Task 02 - Fixed Version
 * Resolves deadlock using consistent locking strategy (lock by account number).
 * Uses wait() and notifyAll() for insufficient balance handling.
 */
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class AccountFixed {
    private int balance;
    private final int accountNumber;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition sufficientFunds = lock.newCondition();
    
    public AccountFixed(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Account " + accountNumber + " deposited: " + amount + 
                              ", New Balance: " + balance);
            sufficientFunds.signalAll(); // Notify waiting threads
        } finally {
            lock.unlock();
        }
    }
    
    public void withdraw(int amount) throws InsufficientBalanceException {
        lock.lock();
        try {
            while (balance < amount) {
                System.out.println("Account " + accountNumber + " has insufficient balance. Waiting...");
                try {
                    sufficientFunds.await(); // Wait until funds are available
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new InsufficientBalanceException("Transfer interrupted");
                }
            }
            balance -= amount;
            System.out.println("Account " + accountNumber + " withdrew: " + amount + 
                              ", New Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public ReentrantLock getLock() {
        return lock;
    }
}

public class BankAccountFixed {
    // Helper method for consistent lock ordering
    private static void transfer(AccountFixed from, AccountFixed to, int amount) 
            throws InterruptedException {
        // Get locks in consistent order (by account number)
        AccountFixed firstLock, secondLock;
        if (from.getAccountNumber() < to.getAccountNumber()) {
            firstLock = from;
            secondLock = to;
        } else {
            firstLock = to;
            secondLock = from;
        }
        
        // Lock in consistent order
        firstLock.getLock().lock();
        secondLock.getLock().lock();
        
        try {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transfer " + amount + " from Account " + from.getAccountNumber() + 
                              " to Account " + to.getAccountNumber() + " completed");
        } catch (InsufficientBalanceException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        } finally {
            secondLock.getLock().unlock();
            firstLock.getLock().unlock();
        }
    }
    
    public static void main(String[] args) {
        AccountFixed accountA = new AccountFixed(1, 1000);
        AccountFixed accountB = new AccountFixed(2, 1000);
        
        // Thread 1: Transfer from A to B
        Thread thread1 = new Thread(() -> {
            try {
                transfer(accountA, accountB, 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Thread 2: Transfer from B to A (will use consistent locking)
        Thread thread2 = new Thread(() -> {
            try {
                transfer(accountB, accountA, 300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Thread 3: Deposit to Account A to wake waiting threads
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(2000); // Wait for potential waiting threads
                accountA.deposit(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}