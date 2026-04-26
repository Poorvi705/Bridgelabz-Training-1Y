import java.sql.*;
import java.util.Scanner;

public class EmployeeRecordSystem {

    static final String URL = "jdbc:mysql://localhost:3306/company_db";
    static final String USER = "root";
    static final String PASSWORD = "1234"; // 🔴 change this to your MySQL password

    public static void main(String[] args) {

        try (
                Scanner sc = new Scanner(System.in);
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD)
        ) {

            // Load driver (important for exam)
            Class.forName("com.mysql.cj.jdbc.Driver");

            while (true) {
                System.out.println("\n--- Employee Salary Manager ---");
                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees with Salary > 30000");
                System.out.println("3. Increase Salary by 10%");
                System.out.println("4. Delete Employees with Salary < 15000");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        addEmployee(con, sc);
                        break;

                    case 2:
                        displayEmployees(con);
                        break;

                    case 3:
                        updateSalary(con, sc);
                        break;

                    case 4:
                        deleteEmployees(con);
                        break;

                    case 5:
                        System.out.println("Exited successfully!");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 CREATE
    public static void addEmployee(Connection con, Scanner sc) throws SQLException {
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        String query = "INSERT INTO employee(name, salary) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setDouble(2, salary);

            int rows = ps.executeUpdate();
            System.out.println(rows + " employee added!");
        }
    }

    // 🔹 READ
    public static void displayEmployees(Connection con) throws SQLException {
        String query = "SELECT * FROM employee WHERE salary > 30000";

        try (
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)
        ) {
            boolean found = false;

            System.out.println("\n--- Employees with Salary > 30000 ---");

            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getDouble("salary")
                );
            }

            if (!found) {
                System.out.println("No employees found!");
            }
        }
    }

    // 🔹 UPDATE
    public static void updateSalary(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        String query = "UPDATE employee SET salary = salary * 1.10 WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Salary updated successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        }
    }

    // 🔹 DELETE
    public static void deleteEmployees(Connection con) throws SQLException {
        String query = "DELETE FROM employee WHERE salary < 15000";

        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows + " employees deleted!");
        }
    }
}