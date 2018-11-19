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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM DOCTORS WHERE ID = ? AND TYPE = ?")) {
            statement.setString(1, oncologistId);
            statement.setString(2, Roles.ROLE_ONCOLOGIST);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createPatient(String name, String surname, String idCode, String insuranceCode) {
        try (Connection conn = DatabaseManager.getConnection();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO PATIENTS (NAME, SURNAME, IDCODE, INSURANCE) VALUES (?, ?, ? , ?)")) {
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, idCode);
            statement.setString(4, insuranceCode);
            statement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean userWithUsernameExists(String username) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?")) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createUser(String username, String password, String role) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD, ROLE) VALUES (?, ?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);
            return statement.executeQuery().next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Patient getPatient(String patientId) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM PATIENTS WHERE IDCODE = ?")) {
            statement.setString(1, patientId);
            try (ResultSet resultSet = statement.executeQuery()) {
                Patient patient = new Patient();
                patient.setIDcode(patientId);
                patient.setName(resultSet.getString("name"));
                patient.setSurname(resultSet.getString("surname"));
                return patient;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Oncologist getSpecialist(String folderId) {
        return null;
    }

    public Collection getAllPatients() {
        List<String> res = new ArrayList<>();
        try (Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM PATIENTS")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    res.add(resultSet.getString("idcode"));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        return res;
    }

    public Collection getAllDoctors(String docType) {
        try {
            List<String> res = new ArrayList<>();
            try (Connection connection = DatabaseManager.getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM DOCTORS WHERE TYPE = ?")) {
                statement.setString(1, docType);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        res.add(resultSet.getString("prof_id"));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } catch (Exception e) {
                throw  new RuntimeException(e);
            }
            return res;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
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
