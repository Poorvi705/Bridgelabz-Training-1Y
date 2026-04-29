public class CheckpointDAO {
    public static void insertCheckpoint(Checkpoint cp, String driverId) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO Checkpoint VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, cp.getCheckpointId());
            ps.setString(2, cp.getLocationName());
            ps.setDouble(3, cp.getDistanceFromLast());
            ps.setInt(4, cp.getExpectedDuration());
            ps.setInt(5, cp.getActualDuration());
            ps.setString(6, cp.getType());
            ps.setString(7, driverId);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}