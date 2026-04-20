import java.util.*;
import java.util.stream.*;

// Doctor Class
class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    public Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    @Override
    public String toString() {
        return name + " | " + specialty +
                " | Weekend Available: " + availableOnWeekend;
    }
}

// Main Class
public class DoctorDemo {

    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Amit", "Cardiology", true),
                new Doctor("Dr. Neha", "Dermatology", false),
                new Doctor("Dr. Ravi", "Neurology", true),
                new Doctor("Dr. Priya", "Orthopedics", true),
                new Doctor("Dr. Karan", "Pediatrics", false)
        );

        System.out.println("Weekend Available Doctors (Sorted by Specialty):");

        doctors.stream()

                // 🔹 Filter weekend doctors
                .filter(d -> d.availableOnWeekend)

                // 🔹 Sort by specialty (A → Z)
                .sorted(Comparator.comparing(d -> d.specialty))

                // 🔹 Print
                .forEach(System.out::println);
    }
}