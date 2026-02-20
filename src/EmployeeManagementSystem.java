
    import java.util.ArrayList;

    // Interface
    interface Department {
        void assignDepartment(String deptName);
        String getDepartmentDetails();
    }

    // Abstract class
    abstract class Employee implements Department {

        // Encapsulation: private fields
        private int employeeId;
        private String name;
        private double baseSalary;
        private String department;

        // Constructor
        public Employee(int employeeId, String name, double baseSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        // Getters and Setters
        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(double baseSalary) {
            this.baseSalary = baseSalary;
        }

        // Interface methods
        @Override
        public void assignDepartment(String deptName) {
            this.department = deptName;
        }

        @Override
        public String getDepartmentDetails() {
            return department;
        }

        // Abstract method
        public abstract double calculateSalary();

        // Concrete method
        public void displayDetails() {
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Name: " + name);
            System.out.println("Department: " + department);
            System.out.println("Salary: " + calculateSalary());
            System.out.println("--------------------------------");
        }
    }

    // Full-time employee
    class FullTimeEmployee extends Employee {

        public FullTimeEmployee(int employeeId, String name, double fixedSalary) {
            super(employeeId, name, fixedSalary);
        }

        @Override
        public double calculateSalary() {
            return getBaseSalary(); // fixed salary
        }
    }

    // Part-time employee
    class PartTimeEmployee extends Employee {

        private int hoursWorked;
        private double hourlyRate;

        public PartTimeEmployee(int employeeId, String name, int hoursWorked, double hourlyRate) {
            super(employeeId, name, 0);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }
    }

    // Main class
    public class EmployeeManagementSystem {

        public static void main(String[] args) {

            ArrayList<Employee> employees = new ArrayList<>();

            Employee emp1 = new FullTimeEmployee(101, "Amit", 50000);
            emp1.assignDepartment("IT");

            Employee emp2 = new PartTimeEmployee(102, "Neha", 40, 500);
            emp2.assignDepartment("HR");

            employees.add(emp1);
            employees.add(emp2);

            // Polymorphism
            for (Employee emp : employees) {
                emp.displayDetails();
            }
        }
    }

