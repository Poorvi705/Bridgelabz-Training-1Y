// Base class Student
class Student {

    protected int rollNo;
    protected String name;
    protected double marks;

    // Constructor
    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Method to calculate grade
    String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    @Override
    public String toString() {
        return "Student{RollNo=" + rollNo + ", Name='" + name + "', Marks=" + marks + "}";
    }
}

// Subclass EngineeringStudent
class EngineeringStudent extends Student {

    private String branch;

    EngineeringStudent(int rollNo, String name, double marks, String branch) {
        super(rollNo, name, marks);
        this.branch = branch;
        // Append branch to student name
        this.name = this.name + " (" + branch + ")";
    }

    @Override
    public String toString() {
        return "EngineeringStudent{RollNo=" + rollNo + ", Name='" + name + "', Marks=" + marks + "}";
    }
}

// Main class
public class StudentResultSystem {

    public static void main(String[] args) {

        Student s1 = new Student(101, "Alice", 85);
        EngineeringStudent s2 = new EngineeringStudent(201, "Bob", 92, "Computer Science");

        System.out.println(s1);
        System.out.println("Grade: " + s1.calculateGrade() + "\n");

        System.out.println(s2);
        System.out.println("Grade: " + s2.calculateGrade());
    }
}