import java.util.*;

// Base class
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }
}

// Subclasses
class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

public class AnimalDemo {

    // Method using wildcard
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            a.display();
        }
    }

    public static void main(String[] args) {

        // Dog list
        List<Dog> dogs = Arrays.asList(
                new Dog("Buddy"),
                new Dog("Rocky")
        );

        // Cat list
        List<Cat> cats = Arrays.asList(
                new Cat("Kitty"),
                new Cat("Luna")
        );

        System.out.println("Dogs:");
        printAnimals(dogs);

        System.out.println("Cats:");
        printAnimals(cats);
    }
}