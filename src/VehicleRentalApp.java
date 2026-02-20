// Interface for insurance
interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

// Abstract class
abstract class Vehicle {

    // Encapsulation: private fields
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Sensitive data (restricted access)
    private String insurancePolicyNumber;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Getters and setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // No direct getter for policy number (encapsulation)
    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);
}

// Car class
class Car extends Vehicle implements Insurable {

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 200 * days; // insurance per day
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance | Policy No: " + getInsurancePolicyNumber();
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 100 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance | Policy No: " + getInsurancePolicyNumber();
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 1000; // extra loading charge
    }

    @Override
    public double calculateInsurance(int days) {
        return 500 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance | Policy No: " + getInsurancePolicyNumber();
    }
}

// Main class
public class VehicleRentalApp {

    // Polymorphism demonstration
    public static void calculateCosts(Vehicle[] vehicles, int days) {

        for (Vehicle v : vehicles) {

            double rentalCost = v.calculateRentalCost(days);
            double insuranceCost = 0;

            if (v instanceof Insurable) {
                insuranceCost = ((Insurable) v).calculateInsurance(days);
            }

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost (" + days + " days): " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Cost: " + (rentalCost + insuranceCost));
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("CAR101", 1500, "CAR-INS-001");
        vehicles[1] = new Bike("BIKE202", 500, "BIKE-INS-002");
        vehicles[2] = new Truck("TRUCK303", 3000, "TRUCK-INS-003");

        int rentalDays = 5;

        calculateCosts(vehicles, rentalDays);
    }
}