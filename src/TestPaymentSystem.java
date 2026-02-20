// Interface (preferred over concrete class)
interface Payment {
    void pay(double amount);
}

// Abstract class providing partial implementation
abstract class OnlinePayment implements Payment {

    protected String providerName;

    OnlinePayment(String providerName) {
        this.providerName = providerName;
    }

    void showProvider() {
        System.out.println("Payment Provider: " + providerName);
    }
}

// Concrete class implementing abstract class
class CreditCardPayment extends OnlinePayment {

    CreditCardPayment(String providerName) {
        super(providerName);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

// Test class
public class TestPaymentSystem {
    public static void main(String[] args) {

        Payment payment = new CreditCardPayment("VISA");

        payment.pay(2500);
        ((OnlinePayment) payment).showProvider();
    }
}