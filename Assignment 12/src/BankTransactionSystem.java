import java.util.Scanner;

// Step 1: Custom Exception (Checked)
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Step 2: BankAccount Class
class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Withdraw method
    public void withdraw(double amount)
            throws InsufficientBalanceException {

        // Check negative amount (unchecked exception)
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        // Check insufficient balance (custom checked exception)
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        // Valid withdrawal
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

// Step 3: Main Class
public class BankTransactionSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(1000); // initial balance

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Invalid input!");

        } finally {
            sc.close();
        }
    }
}