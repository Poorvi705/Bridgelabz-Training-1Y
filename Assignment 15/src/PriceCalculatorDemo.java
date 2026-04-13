import java.util.*;

// Base class
class Product {
    double price;

    Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// Subclasses
class Mobile extends Product {
    Mobile(double price) {
        super(price);
    }
}

class Laptop extends Product {
    Laptop(double price) {
        super(price);
    }
}

public class PriceCalculatorDemo {

    // Generic method
    public static double calculateTotal(List<? extends Product> items) {
        double total = 0.0;

        for (Product p : items) {
            total += p.getPrice();
        }

        return total;
    }

    public static void main(String[] args) {

        // Mobile list
        List<Mobile> mobiles = Arrays.asList(
                new Mobile(15000),
                new Mobile(20000)
        );

        // Laptop list
        List<Laptop> laptops = Arrays.asList(
                new Laptop(50000),
                new Laptop(70000)
        );

        System.out.println("Total Mobile Price: " + calculateTotal(mobiles));
        System.out.println("Total Laptop Price: " + calculateTotal(laptops));
    }
}