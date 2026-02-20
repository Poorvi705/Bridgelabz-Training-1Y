// Abstract superclass (blueprint with partial implementation)
abstract class Shape {

    // Abstract method (must be implemented by subclasses)
    abstract void draw();

    // Concrete method (common implementation)
    void displayType() {
        System.out.println("This is a shape");
    }
}

// Subclass providing implementation
class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

// Another subclass
class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Main class
public class AbstractClassDemo {
    public static void main(String[] args) {

        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.displayType();
        s1.draw();

        s2.displayType();
        s2.draw();
    }
}