/**
 * @(#) AnamnesisDAO.java
 */

package his.sequence.diagrams;

import his.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnamnesisDAO {
    public String createAnamnesis(String patientId, String text) {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ANAMNESES (PATIENTID, TEXT) VALUES (?, ?)")) {
            preparedStatement.setString(1, patientId);
            preparedStatement.setString(2, text);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.getString("id");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
