import java.sql.Connection;
import java.sql.PreparedStatement;

public class DriverDAO {
    public static void insertDriver(Driver driver) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO Driver VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, driver.getDriverId());
            ps.setString(2, driver.getName());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}