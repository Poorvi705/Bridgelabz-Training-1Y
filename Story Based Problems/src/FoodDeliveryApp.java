// Parent class
class Order {

    protected int orderId;
    protected double baseAmount;

    // Static delivery charge shared by all orders
    static double deliveryCharge = 40.0;

    // Constructor
    Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }

    // Method to calculate final bill (can be overridden)
    double calculateBill() {
        return baseAmount + deliveryCharge;
    }

    @Override
    public String toString() {
        return "Order{ID=" + orderId + ", BaseAmount=₹" + baseAmount + "}";
    }
}

// RegularOrder → no discount
class RegularOrder extends Order {

    RegularOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    double calculateBill() {
        return baseAmount + deliveryCharge; // no discount
    }
}

// PremiumOrder → 20% discount
class PremiumOrder extends Order {

    PremiumOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    double calculateBill() {
        double discountedAmount = baseAmount * 0.8; // 20% discount
        return discountedAmount + deliveryCharge;
    }
}

// Main class
public class FoodDeliveryApp {

    public static void main(String[] args) {

        // Polymorphic references
        Order order1 = new RegularOrder(101, 300.0);
        Order order2 = new PremiumOrder(102, 500.0);

        System.out.println(order1);
        System.out.println("Total Bill: ₹" + order1.calculateBill() + "\n");

        System.out.println(order2);
        System.out.println("Total Bill: ₹" + order2.calculateBill());
    }
}