import java.util.*;

// Product Classes
class Electronics {
    String name;

    Electronics(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Clothing {
    String name;

    Clothing(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

// Generic Cart Class
class Cart<T> {
    private List<T> items = new ArrayList<>();

    // Add item
    public void addItem(T item) {
        items.add(item);
    }

    // Remove item
    public void removeItem(T item) {
        items.remove(item);
    }

    // Display items
    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

public class CartDemo {
    public static void main(String[] args) {

        // Electronics Cart
        Cart<Electronics> electronicsCart = new Cart<>();
        electronicsCart.addItem(new Electronics("Laptop"));
        electronicsCart.addItem(new Electronics("Mobile"));

        System.out.println("Electronics Cart:");
        electronicsCart.displayItems();

        // Clothing Cart
        Cart<Clothing> clothingCart = new Cart<>();
        clothingCart.addItem(new Clothing("Shirt"));
        clothingCart.addItem(new Clothing("Jeans"));

        System.out.println("\nClothing Cart:");
        clothingCart.displayItems();

        // ❌ Not allowed (type safety)
        // electronicsCart.addItem(new Clothing("T-Shirt"));
    }
}