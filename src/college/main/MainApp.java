package college.main;

import college.students.Students;
import college.facultys.Facultys;
import college.departments.Departments;

import static java.lang.System.out;

public class MainApp {

    public static void main(String[] args) {

        Students s1 = new Students("Rahul", 101);
        Facultys f1 = new Facultys("Dr. Sharma", "Java Programming");
        Departments d1 = new Departments("Computer Science");

        out.println("----- College Information -----");

        s1.displayStudent();
        out.println();

        f1.displayFaculty();
        out.println();

        d1.displayDepartment();
    }
}