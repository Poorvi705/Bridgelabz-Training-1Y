// Interface for loan facility
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility(double amount);
}

// Abstract class
abstract class BankAccount {

    // Encapsulation: private fields
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters (no setter for account number for security)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Protected method for subclasses
    protected void addInterest(double interest) {
        balance += interest;
    }

    // Abstract method
    public abstract void calculateInterest();
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * 0.04; // 4% interest
        addInterest(interest);
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility(amount)) {
            System.out.println("Loan approved for Savings Account");
        } else {
            System.out.println("Loan rejected for Savings Account");
        }
    }

    @Override
    public boolean calculateLoanEligibility(double amount) {
        return getBalance() >= amount * 0.5;
    }
}

// Current Account
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * 0.02; // 2% interest
        addInterest(interest);
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility(amount)) {
            System.out.println("Loan approved for Current Account");
        } else {
            System.out.println("Loan rejected for Current Account");
        }
    }

    @Override
    public boolean calculateLoanEligibility(double amount) {
        return getBalance() >= amount * 0.3;
    }
}

// Main class
public class BankingApp {

    // Polymorphism demonstration
    public static void processAccounts(BankAccount[] accounts) {

        for (BankAccount acc : accounts) {

            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Balance before interest: " + acc.getBalance());

            acc.calculateInterest(); // dynamic binding

            System.out.println("Balance after interest: " + acc.getBalance());

            if (acc instanceof Loanable) {
                ((Loanable) acc).applyForLoan(50000);
            }

            System.out.println("---------------------------------");
        }
    }

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[2];

        accounts[0] = new SavingsAccount("SAV101", "Poorvi", 100000);
        accounts[1] = new CurrentAccount("CUR202", "Amit", 150000);

        processAccounts(accounts);
    }
}
