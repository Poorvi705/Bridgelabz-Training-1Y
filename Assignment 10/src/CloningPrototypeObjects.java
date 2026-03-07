class Product implements Cloneable {

    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Override clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

// Main class
public class CloningPrototypeObjects {

    public static void main(String[] args) {

        Product original = new Product("Laptop", 1500.0);
        System.out.println("Original Product: " + original);

        try {
            // Clone the product
            Product cloned = (Product) original.clone();
            System.out.println("Cloned Product: " + cloned);

            // Modify cloned object to show they are separate
            cloned = new Product("Laptop - Clone", 1400.0);
            System.out.println("Modified Cloned Product: " + cloned);
            System.out.println("Original Product still: " + original);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}