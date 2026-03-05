package college.students;

public class Students {  String name;
    int rollNo;

    public Students(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}
