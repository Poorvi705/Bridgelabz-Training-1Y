// Superclass
class Device {
    String brand;

    // Superclass constructor
    Device(String brand) {
        this.brand = brand;

        // ❌ Avoid calling overridable methods here
        // setup();  // This can cause issues if overridden
    }

    // Safe method (not overridden)
    final void showBrand() {
        System.out.println("Brand: " + brand);
    }

    // Overridable method
    void setup() {
        System.out.println("Setting up generic device");
    }
}

// Subclass
class Laptop extends Device {
    int ram;

    // Subclass constructor explicitly calling super()
    Laptop(String brand, int ram) {
        super(brand);   // Explicit superclass constructor call
        this.ram = ram;
    }

    // Overridden method
    @Override
    void setup() {
        System.out.println("Setting up laptop with RAM: " + ram + " GB");
    }

    void displayDetails() {
        showBrand();
        System.out.println("RAM: " + ram + " GB");
    }
}

// Main class
public class ConstructorCautionDemo {
    public static void main(String[] args) {

        Laptop laptop = new Laptop("Dell", 16);
        laptop.displayDetails();
    }
}