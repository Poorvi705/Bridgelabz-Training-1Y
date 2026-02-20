// Superclass
class Printer {

    void print(String message) {
        System.out.println("Printer prints: " + message);
    }
}

// Subclass
class LaserPrinter extends Printer {

    // Proper overriding (same method signature)
    @Override
    void print(String message) {
        System.out.println("LaserPrinter prints: " + message);
    }


}

// Main class
public class AvoidOverloadingWithOverridingDemo {
    public static void main(String[] args) {

        Printer printer = new LaserPrinter(); // Polymorphism
        printer.print("Hello OOP");
    }
}