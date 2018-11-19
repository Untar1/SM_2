/**
 * @(#) UserDAO.java
 */

package his.sequence.diagrams;

import his.DatabaseManager;
import his.Oncologist;
import his.Patient;
import his.implementation.Roles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

public class UserDAO {
    public boolean doctorWIthIdExists(String id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM DOCTORS WHERE ID = ?")) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String createDoctor(String professionalId, String name, String surname, String type, String subType) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("INSERT INTO DOCTORS (PROF_ID, NAME, SURNAME, TYPE, SUBTYPE) VALUES (?, ?, ? , ?, ?)")) {
            statement.setString(1, professionalId);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.setString(4, type);
            statement.setString(5, subType);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.getString("id");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean patientWithIdExists(String id) {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS WHERE ID = ? AND ROLE = 'Patient'")) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean surgeonWithIdExists(String id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM DOCTORS WHERE ID = ? AND TYPE = ?")) {
            statement.setString(1, id);
            statement.setString(2, Roles.ROLE_SURGEON);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean getUserWithUsernameAndPassword(String username, String password) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean oncologistWithIdExists(String oncologistId) {
        return false;
    }

    public void createPatient(String name, String surname, String idCode, String insuranceCode) {

    }

    public boolean userWithUsernameExists(String username) {
        return false;
    }

    public boolean createUser(String username, String password, String role) {
        return false;
    }

    public Patient getPatient(String patientId) {
        return null;
    }

    public Oncologist getSpecialist(String folderId) {
        return null;
    }

    public Collection getAllPatients() {
        return null;
    }

    public Collection getAllDoctors(String docType) {
        return null;
    }

    public String getOncologist(String id) {
        return null;
    }

    public static String getUserRole(String username) {
        try (Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
             PreparedStatement stmt = con.prepareStatement("SELECT ROLE FROM USERS WHERE USERNAME = ?")) {
            stmt.setString(1, username);
            try (ResultSet resultSet = stmt.executeQuery()) {
                return resultSet.getString("role");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
