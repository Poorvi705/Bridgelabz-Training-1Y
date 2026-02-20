// Base class
class Vehicle {
    void move() {
        System.out.println("Vehicle is moving");
    }
}

// Shallow inheritance (recommended)
class Car extends Vehicle {
    void playMusic() {
        System.out.println("Car is playing music");
    }
}

// Main class
public class ShallowInheritanceDemo {
    public static void main(String[] args) {

        Vehicle v = new Car();   // Simple and clear inheritance
        v.move();

        Car c = new Car();
        c.playMusic();
    }
}