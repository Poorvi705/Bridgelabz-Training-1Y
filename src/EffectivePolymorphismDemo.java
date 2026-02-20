// Superclass
class Payment {
    void pay() {
        System.out.println("Processing generic payment");
    }
}

// Subclass 1
class CreditCardPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Processing credit card payment");
    }
}

// Subclass 2
class UpiPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Processing UPI payment");
    }
}

// Subclass 3
class CashPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Processing cash payment");
    }
}

// Main class demonstrating polymorphism
public class EffectivePolymorphismDemo {
    public static void main(String[] args) {

        // Superclass references holding subclass objects
        Payment[] payments = new Payment[3];

        payments[0] = new CreditCardPayment();
        payments[1] = new UpiPayment();
        payments[2] = new CashPayment();

        // Dynamic method dispatch
        for (Payment p : payments) {
            p.pay();
        }
    }
}