import java.util.*;

// Abstract base class
abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    abstract void display();
}

// Subclasses
class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }

    void display() {
        System.out.println("Electronics: " + name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }

    void display() {
        System.out.println("Groceries: " + name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }

    void display() {
        System.out.println("Furniture: " + name);
    }
}

// Generic Storage Class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

public class WarehouseDemo {

    // Wildcard method
    public static void displayAll(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.display();
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("TV"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics Items:");
        displayAll(electronicsStorage.getItems());

        System.out.println("\nGrocery Items:");
        displayAll(groceryStorage.getItems());

        System.out.println("\nFurniture Items:");
        displayAll(furnitureStorage.getItems());
    }
}