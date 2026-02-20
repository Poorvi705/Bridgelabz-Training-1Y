// Superclass
class Bird {
    void eat() {
        System.out.println("Bird is eating");
    }
}

// Subclass that follows LSP
class FlyingBird extends Bird {
    void fly() {
        System.out.println("Bird is flying");
    }
}

// Another subclass that also follows LSP
class Sparrow extends FlyingBird {
    @Override
    void eat() {
        System.out.println("Sparrow is eating grains");
    }
}

// Main class
public class LiskovSubstitutionDemo {
    public static void main(String[] args) {

        Bird b1 = new Bird();
        Bird b2 = new Sparrow();   // Substitutable without breaking behavior

        b1.eat();
        b2.eat();
    }
}