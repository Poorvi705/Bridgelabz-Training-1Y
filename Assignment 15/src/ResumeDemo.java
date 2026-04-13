import java.util.*;

// Abstract base class
abstract class JobRole {
    String candidateName;

    JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    abstract void evaluate();
}

// Subclasses
class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String name) {
        super(name);
    }

    void evaluate() {
        System.out.println(candidateName + " evaluated for Software Engineer role");
    }
}

class DataScientist extends JobRole {
    DataScientist(String name) {
        super(name);
    }

    void evaluate() {
        System.out.println(candidateName + " evaluated for Data Scientist role");
    }
}

class ProductManager extends JobRole {
    ProductManager(String name) {
        super(name);
    }

    void evaluate() {
        System.out.println(candidateName + " evaluated for Product Manager role");
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private T role;

    public void setResume(T role) {
        this.role = role;
    }

    public void process() {
        role.evaluate();
    }
}

public class ResumeDemo {

    // Wildcard method for screening pipeline
    public static void screenResumes(List<? extends JobRole> candidates) {
        for (JobRole c : candidates) {
            c.evaluate();
        }
    }

    public static void main(String[] args) {

        // Individual resume processing
        Resume<SoftwareEngineer> seResume = new Resume<>();
        seResume.setResume(new SoftwareEngineer("Alice"));
        seResume.process();

        Resume<DataScientist> dsResume = new Resume<>();
        dsResume.setResume(new DataScientist("Bob"));
        dsResume.process();

        // Screening pipeline
        List<SoftwareEngineer> seList = Arrays.asList(
                new SoftwareEngineer("Charlie"),
                new SoftwareEngineer("David")
        );

        List<DataScientist> dsList = Arrays.asList(
                new DataScientist("Eve"),
                new DataScientist("Frank")
        );

        System.out.println("\nScreening Software Engineers:");
        screenResumes(seList);

        System.out.println("\nScreening Data Scientists:");
        screenResumes(dsList);
    }
}