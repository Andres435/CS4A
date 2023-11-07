/*
    Print an account summary that shows account holder name, interest rate, balance, and all transactions.
*/
import java.util.ArrayList;

public class HW11_8 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Account account = new Account("George", 1000, 1.5);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);
        System.out.println(account);
    }
}

class Transaction{
    char type;
    double amount;
    double balance;
    String description;

    public Transaction(char type, double amount, double balance, String description){
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Type: " + type + "\n" + "Amount: " + "\n" + "Balance: " + balance + "\n" + "Description: " + description;
    }
}

class Account {
    private String name;
    private double balance;
    private double annualInterestRate;
    private ArrayList<Transaction> transactions;


    public Account() {
        transactions = new ArrayList<>();
    }

    public Account(String name, double balance, double annualInterestRate) {
        this();
        this.balance = balance;
        this.name = name;
        this.annualInterestRate = annualInterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw(double amount) {
        transactions.add(new Transaction('W', amount, balance, "withdraw"));
        balance -= amount;
    }

    public void deposit(double amount) {
        transactions.add(new Transaction('D', amount, balance, "deposit"));
        balance += amount;
    }

    @Override
    public String toString() {
        return "Account name: " +name + "\n" + "Interest rate: " + annualInterestRate + "\n" + transactions;
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
