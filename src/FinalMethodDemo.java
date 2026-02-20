// Superclass
class BankAccount {

    // Critical method marked as final
    final void calculateInterest() {
        System.out.println("Interest calculated using bank rules");
    }
}

// Subclass
class SavingsAccount extends BankAccount {

    // Overriding is NOT allowed for final methods
    // Uncommenting below code will cause a compile-time error
    /*
    @Override
    void calculateInterest() {
        System.out.println("Custom interest logic");
    }
    */

    void showAccountType() {
        System.out.println("Savings Account");
    }
}

// Main class
public class FinalMethodDemo {
    public static void main(String[] args) {

        BankAccount account = new SavingsAccount();
        account.calculateInterest();   // Always uses superclass logic
    }
}