package MODEL.DAO;

import MODEL.DTO.Event.VolunteeringDetailsDTO;
import MODEL.Patterns.singleton.DbConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VolunteeringDetailsDAO {

    // Add a volunteering details record to the database
   public static boolean addVolunteeringDetails(VolunteeringDetailsDTO details) throws SQLException {
    String sql = "INSERT INTO volunteering_details (event_id, volunteering_id, hours, status) VALUES (?, ?, ?, ?)";

    try (Connection connection = DbConnectionSingleton.getInstance().getConnection();
         PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
        
        pstmt.setInt(1, details.getEventId());
        pstmt.setInt(2, details.getVolunteeringId());
        pstmt.setInt(3, details.getHours());
        pstmt.setString(4, details.getStatus());

        int affectedRows = pstmt.executeUpdate();

        if (affectedRows == 1) {
            // Get the generated ID for the new record
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1); // Retrieve the auto-generated id
                    details.setId(generatedId); // Set the generated ID in the DTO
                    return true;
                }
            }
        }
    }
    return false;
}

    // Remove a volunteering details record from the database
    public static boolean removeVolunteeringDetails(int detailsId) throws SQLException {
        String sql = "DELETE FROM volunteering_details WHERE id = ?";

        try (Connection connection = DbConnectionSingleton.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, detailsId);
            return pstmt.executeUpdate() == 1;
        }
    }

    // Retrieve a list of all volunteering details
    public static List<VolunteeringDetailsDTO> getAllVolunteeringDetails() throws SQLException {
        String sql = "SELECT id, event_id, volunteering_id, hours, status FROM volunteering_details";
        List<VolunteeringDetailsDTO> detailsList = new ArrayList<>();

        try (Connection connection = DbConnectionSingleton.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rset = pstmt.executeQuery()) {

            while (rset.next()) {
                VolunteeringDetailsDTO details = new VolunteeringDetailsDTO(
                    rset.getInt("id"),
                    rset.getInt("event_id"),
                    rset.getInt("volunteering_id"),
                    rset.getInt("hours"),
                    rset.getString("status")
                );
                detailsList.add(details);
            }
        }
        return detailsList;
    }

    // Get specific volunteering details by ID
    public static VolunteeringDetailsDTO getVolunteeringDetailsById(int id) throws SQLException {
        String sql = "SELECT id, event_id, volunteering_id, hours, status FROM volunteering_details WHERE id = ?";

        try (Connection connection = DbConnectionSingleton.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    return new VolunteeringDetailsDTO(
                        rset.getInt("id"),
                        rset.getInt("event_id"),
                        rset.getInt("volunteering_id"),
                        rset.getInt("hours"),
                        rset.getString("status")
                    );
                }
            }
        }
        return null; // Return null if no volunteering details are found with the given ID
    }
}
