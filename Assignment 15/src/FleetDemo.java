import java.util.*;

// Base class
class Vehicle {
    String name;

    Vehicle(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

// Subclasses
class Truck extends Vehicle {
    Truck(String name) {
        super(name);
    }
}

class Bike extends Vehicle {
    Bike(String name) {
        super(name);
    }
}

// Generic Fleet Manager
class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
    }

    public void showFleet() {
        for (T v : fleet) {
            System.out.println(v);
        }
    }
}

public class FleetDemo {
    public static void main(String[] args) {

        // Truck Fleet
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Tata Truck"));
        truckFleet.addVehicle(new Truck("Volvo Truck"));

        System.out.println("Truck Fleet:");
        truckFleet.showFleet();

        // Bike Fleet
        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Yamaha"));
        bikeFleet.addVehicle(new Bike("Royal Enfield"));

        System.out.println("\nBike Fleet:");
        bikeFleet.showFleet();

        // ❌ Not allowed
        // FleetManager<String> wrongFleet = new FleetManager<>();
    }
}