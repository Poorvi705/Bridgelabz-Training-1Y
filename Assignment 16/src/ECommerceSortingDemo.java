import java.util.*;

// Product Class
class Product {
    String name;
    double price;
    double rating;
    double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price +
                " | Rating: " + rating +
                " | Discount: " + discount + "%";
    }
}

// Main Class
public class ECommerceSortingDemo {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 60000, 4.5, 10));
        products.add(new Product("Phone", 30000, 4.7, 15));
        products.add(new Product("Headphones", 2000, 4.2, 20));
        products.add(new Product("Smartwatch", 5000, 4.3, 25));

        System.out.println("Original List:");
        products.forEach(System.out::println);

        // 🔹 Sort by Price (Low to High)
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("\nSorted by Price:");
        products.forEach(System.out::println);

        // 🔹 Sort by Rating (High to Low)
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);

        // 🔹 Sort by Discount (High to Low)
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}