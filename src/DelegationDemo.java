// Special behavior interface
interface DiscountStrategy {
    double applyDiscount(double amount);
}

// Concrete delegated class
class FestivalDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.8; // 20% discount
    }
}

// Another delegated class
class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}

// Main class using delegation
class Order {

    private double amount;
    private DiscountStrategy discountStrategy; // Delegation

    Order(double amount, DiscountStrategy discountStrategy) {
        this.amount = amount;
        this.discountStrategy = discountStrategy;
    }

    double calculateFinalAmount() {
        return discountStrategy.applyDiscount(amount);
    }
}

// Test class
public class DelegationDemo {
    public static void main(String[] args) {

        Order normalOrder = new Order(1000, new NoDiscount());
        Order festivalOrder = new Order(1000, new FestivalDiscount());

        System.out.println("Normal Order Amount: ₹" + normalOrder.calculateFinalAmount());
        System.out.println("Festival Order Amount: ₹" + festivalOrder.calculateFinalAmount());
    }
}