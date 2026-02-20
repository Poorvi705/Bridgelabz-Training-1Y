
class Account {
    protected double balance;


    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }


    void displayDetails() {
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class
public class DocumentInheritanceDemo {
    public static void main(String[] args) {

        Account account = new SavingsAccount(4.5);
        account.deposit(10000);
        account.displayDetails();
    }
}