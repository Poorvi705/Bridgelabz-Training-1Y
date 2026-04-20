import java.util.*;

// Patient Class
class Patient {
    int id;
    String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}

public class PatientDemo {

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        patients.add(new Patient(101, "Amit"));
        patients.add(new Patient(102, "Neha"));
        patients.add(new Patient(103, "Ravi"));

        System.out.println("Patient IDs:");

        // 🔹 Method Reference
        patients.stream()
                .map(Patient::getId)   // method reference
                .forEach(System.out::println);  // method reference
    }
}