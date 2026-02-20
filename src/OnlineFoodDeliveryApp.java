// Interface for discount feature
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class
abstract class FoodItem {

    // Encapsulation: private fields
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters (no setters for security)
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

// Veg item class
class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

// Non-veg item class
class NonVegItem extends FoodItem implements Discountable {

    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double basePrice = getPrice() * getQuantity();
        double extraCharge = basePrice * 0.15; // 15% extra charge
        return basePrice + extraCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

// Main class
public class OnlineFoodDeliveryApp {

    // Polymorphism demonstration
    public static void processOrder(FoodItem[] items) {

        double grandTotal = 0;

        for (FoodItem item : items) {

            item.getItemDetails();

            double totalPrice = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                discount = ((Discountable) item).applyDiscount();
                System.out.println(((Discountable) item).getDiscountDetails());
            }

            double finalPrice = totalPrice - discount;
            grandTotal += finalPrice;

            System.out.println("Total Price: " + totalPrice);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("--------------------------------");
        }

        System.out.println("Grand Total Order Amount: " + grandTotal);
    }

    public static void main(String[] args) {

        FoodItem[] order = new FoodItem[3];

        order[0] = new VegItem("Paneer Butter Masala", 250, 2);
        order[1] = new NonVegItem("Chicken Biryani", 300, 1);
        order[2] = new VegItem("Butter Naan", 40, 4);

        processOrder(order);
    }
}