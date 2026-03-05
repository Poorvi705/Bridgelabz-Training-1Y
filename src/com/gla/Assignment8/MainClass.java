package com.gla.Assignment8;

import college.student.Student;
import college.faculty.Faculty;

public class MainClass {

    public static void main(String[] args) {

        Student s = new Student("Rahul", 101);
        Faculty f = new Faculty("Dr Sharma", "Mathematics");

        s.displayStudent();
        System.out.println();
        f.displayFaculty();
    }
}