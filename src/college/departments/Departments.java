package college.departments;

public class Departments {   String deptName;

    public Departments(String deptName) {
        this.deptName = deptName;
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
    }
}
