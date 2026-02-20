// Superclass
class Account {
    protected double balance;

    Account(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

// Subclass
class SavingsAccount extends Account {

    SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    void deposit(double amount) {
        // Extra behavior added in subclass
        if (amount > 0) {
            super.deposit(amount);
            System.out.println("SavingsAccount deposit successful");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
}

// Test class
public class TestInheritanceInteraction {
    public static void main(String[] args) {

        Account acc = new SavingsAccount(1000);

        // Testing superclass + subclass interaction
        acc.deposit(500);
        acc.displayBalance();

        acc.deposit(-200);   // testing edge case
        acc.displayBalance();
    }
}