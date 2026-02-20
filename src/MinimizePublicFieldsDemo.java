// Superclass
class Employee {
    // Fields are NOT public
    private String name;
    private double salary;

    // Constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {   // validation
            this.salary = salary;
        }
    }
}

// Subclass
class Manager extends Employee {
    private int teamSize;

    Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + getSalary());
        System.out.println("Team Size: " + teamSize);
    }
}

// Main class
public class MinimizePublicFieldsDemo {
    public static void main(String[] args) {

        Manager m = new Manager("Rohit", 80000, 6);
        m.displayDetails();

        // Safe modification using setter
        m.setSalary(85000);
        System.out.println("Updated Salary: " + m.getSalary());
    }
}