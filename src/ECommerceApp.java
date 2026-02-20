interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class
abstract class Product {

    // Encapsulation: private fields
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();
}

// Electronics class
class Electronics extends Product implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% tax
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 12%";
    }
}

// Groceries class (No tax)
class Groceries extends Product {

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class
public class ECommerceApp {

    // Polymorphism in action
    public static void calculateFinalPrice(Product[] products) {

        for (Product p : products) {

            double price = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = 0;

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
            }

            double finalPrice = price + tax - discount;

            System.out.println("Product Name: " + p.getName());
            System.out.println("Base Price: " + price);
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {

        Product[] products = new Product[3];

        products[0] = new Electronics(101, "Laptop", 60000);
        products[1] = new Clothing(102, "Jacket", 3000);
        products[2] = new Groceries(103, "Rice", 1000);

        calculateFinalPrice(products);
    }
}