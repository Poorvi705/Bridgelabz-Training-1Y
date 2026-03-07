// Base class Product
class Product {

    protected int productId;
    protected String productName;

    // Constructor
    Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    // Check if product name matches the keyword
    boolean isMatch(String keyword) {
        return productName.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public String toString() {
        return "Product{ID=" + productId + ", Name='" + productName + "'}";
    }
}

// Subclass ElectronicProduct
class ElectronicProduct extends Product {

    private String brand;

    ElectronicProduct(int productId, String productName, String brand) {
        super(productId, productName);
        this.brand = brand;
    }

    @Override
    boolean isMatch(String keyword) {
        keyword = keyword.toLowerCase();
        return productName.toLowerCase().contains(keyword) || brand.toLowerCase().contains(keyword);
    }

    @Override
    public String toString() {
        return "ElectronicProduct{ID=" + productId + ", Name='" + productName + "', Brand='" + brand + "'}";
    }
}

// Main class
public class ProductCategorization {

    public static void main(String[] args) {

        Product prod1 = new Product(101, "Leather Wallet");
        ElectronicProduct prod2 = new ElectronicProduct(201, "Smartphone", "Samsung");
        ElectronicProduct prod3 = new ElectronicProduct(202, "Laptop", "Dell");

        String keyword = "samsung";

        System.out.println(prod1 + " → Match? " + prod1.isMatch(keyword));
        System.out.println(prod2 + " → Match? " + prod2.isMatch(keyword));
        System.out.println(prod3 + " → Match? " + prod3.isMatch(keyword));
    }
}