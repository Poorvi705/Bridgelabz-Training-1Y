import java.sql.*;
public class RouteService {
    public static RouteLinkedList<Checkpoint> loadRoute(String driverId) {
        RouteLinkedList<Checkpoint> route = new RouteLinkedList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM Checkpoint WHERE driverId=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, driverId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String type = rs.getString("type");

                Checkpoint cp;

                if (type.equals("Delivery")) {
                    cp = new DeliveryCheckpoint(...);
                } else if (type.equals("Fuel")) {
                    cp = new FuelCheckpoint(...);
                } else {
                    cp = new RestCheckpoint(...);
                }

                route.addCheckpoint(cp);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return route;
    }
}