// Superclass
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass correctly using IS-A relationship
class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

// Main class
public class IsARelationshipDemo {
    public static void main(String[] args) {

        Animal a1 = new Animal();
        Animal a2 = new Dog();   // IS-A relationship + polymorphism

        a1.makeSound();
        a2.makeSound();
    }
}