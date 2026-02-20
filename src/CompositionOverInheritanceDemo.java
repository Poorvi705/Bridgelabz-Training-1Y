// Engine class (independent class)
class Engine {
    void start() {
        System.out.println("Engine starts");
    }
}

// Car class uses composition (HAS-A relationship)
class Car {
    private Engine engine;   // Car HAS-A Engine

    // Constructor
    Car() {
        engine = new Engine();
    }

    void startCar() {
        engine.start();   // Delegation
        System.out.println("Car is moving");
    }
}

// Main class
public class CompositionOverInheritanceDemo {
    public static void main(String[] args) {

        Car car = new Car();
        car.startCar();
    }
}