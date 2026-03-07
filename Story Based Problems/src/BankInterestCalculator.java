// Parent class
class Account {

    protected int accountNumber;
    protected double balance;

    // Static field shared by all accounts
    static String bankName = "Global Bank";

    // Constructor
    Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to calculate interest (to be overridden)
    double calculateInterest() {
        System.out.println("Generic account interest calculation.");
        return 0.0;
    }

    @Override
    public String toString() {
        return "Account{Number=" + accountNumber + ", Balance=₹" + balance + "}";
    }
}

// SavingsAccount → 4%
class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 0.04;

    SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// CurrentAccount → 2%
class CurrentAccount extends Account {

    private static final double INTEREST_RATE = 0.02;

    CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// Main class
public class BankInterestCalculator {

    public static void main(String[] args) {

        System.out.println("Bank: " + Account.bankName + "\n");

        // Polymorphic references
        Account acc1 = new SavingsAccount(1001, 50000.0);
        Account acc2 = new CurrentAccount(2001, 75000.0);

        System.out.println(acc1);
        System.out.println("Interest: ₹" + acc1.calculateInterest() + "\n");

        System.out.println(acc2);
        System.out.println("Interest: ₹" + acc2.calculateInterest());
    }
}