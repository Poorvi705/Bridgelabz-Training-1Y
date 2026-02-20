// Superclass
class Shape {

    void draw() {
        System.out.println("Drawing a shape");
    }
}

// Subclass
class Circle extends Shape {

    // Using @Override ensures correct method overriding
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

// Main class
public class OverrideAnnotationDemo {
    public static void main(String[] args) {

        Shape s = new Circle();   // Polymorphism
        s.draw();
    }
}