import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/logistics",
                    "root",
                    "Poorvi@123"
            );

            System.out.println("Connected to MySQL ");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}