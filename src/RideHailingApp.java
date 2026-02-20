// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract class
abstract class Vehicle {

    // Encapsulation: private fields
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // GPS data (protected access)
    private String currentLocation;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Unknown";
    }

    // Getters (no setters for ID and driver for security)
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    protected String getLocation() {
        return currentLocation;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Current Location: " + currentLocation);
    }
}

// Car class
class Car extends Vehicle implements GPS {

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

// Bike class
class Bike extends Vehicle implements GPS {

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; // no base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

// Auto class
class Auto extends Vehicle implements GPS {

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 20; // small base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

// Main class
public class RideHailingApp {

    // Polymorphism demonstration
    public static void calculateRideFare(Vehicle[] vehicles, double distance) {

        for (Vehicle v : vehicles) {

            v.getVehicleDetails();
            double fare = v.calculateFare(distance);
            System.out.println("Distance: " + distance + " km");
            System.out.println("Fare: " + fare);
            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[3];

        Car car = new Car("CAR101", "Ramesh", 15);
        Bike bike = new Bike("BIKE202", "Suresh", 8);
        Auto auto = new Auto("AUTO303", "Mahesh", 10);

        car.updateLocation("MG Road");
        bike.updateLocation("City Center");
        auto.updateLocation("Railway Station");

        vehicles[0] = car;
        vehicles[1] = bike;
        vehicles[2] = auto;

        calculateRideFare(vehicles, 10); // 10 km ride
    }
}