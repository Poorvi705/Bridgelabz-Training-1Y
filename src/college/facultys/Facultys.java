package college.facultys;

public class Facultys {  String name;
    String subject;

    public Facultys(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void displayFaculty() {
        System.out.println("Faculty Name: " + name);
        System.out.println("Subject: " + subject);
    }
}
