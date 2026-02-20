// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class
abstract class Patient {

    // Encapsulation: private fields
    private int patientId;
    private String name;
    private int age;

    // Sensitive data (protected access)
    private String diagnosis;
    private String medicalHistory;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters (no setters for sensitive data)
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Protected methods for subclasses
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected String getMedicalHistory() {
        return medicalHistory;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {

    private int numberOfDays;
    private double dailyCharge;
    private String record;

    public InPatient(int id, String name, int age, int days, double dailyCharge) {
        super(id, name, age);
        this.numberOfDays = days;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return numberOfDays * dailyCharge + 2000; // includes service charges
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
        setMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + getMedicalHistory());
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;
    private String record;

    public OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
        setMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + getMedicalHistory());
    }
}

// Main class
public class HospitalApp {

    // Polymorphism demonstration
    public static void processPatients(Patient[] patients) {

        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Total Bill: " + p.calculateBill());

            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }

            System.out.println("---------------------------------");
        }
    }

    public static void main(String[] args) {

        Patient[] patients = new Patient[2];

        InPatient inPatient = new InPatient(101, "Poorvi", 21, 5, 3000);
        inPatient.addRecord("Admitted for surgery and observation");

        OutPatient outPatient = new OutPatient(102, "Amit", 30, 800);
        outPatient.addRecord("General check-up and consultation");

        patients[0] = inPatient;
        patients[1] = outPatient;

        processPatients(patients);
    }
}