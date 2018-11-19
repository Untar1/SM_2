

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {

    private static Class<?> driver;

    public static void initializeDatabase() {
        Connection con = null;
        Statement stmt = null;
        try {
            initDriver();
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE users (\n" +
                    "  id       VARCHAR(20) NOT NULL,\n" +
                    "  username VARCHAR(30) NOT NULL,\n" +
                    "  password VARCHAR(30) NOT NULL,\n" +
                    "  role     varchar(20) NOT NULL,\n" +
                    "  type     VARCHAR(20) NOT NULL,\n" +
                    "  subtype  VARCHAR(20) NOT NULL,\n" +
                    "  PRIMARY KEY (id)\n" +
                    ");\n");

            stmt.executeUpdate("CREATE TABLE company (\n" +
                    "  id VARCHAR(20),\n" +
                    "  name VARCHAR(20)\n" +
                    ");");

            stmt.executeUpdate("CREATE TABLE anamneses (\n" +
                    "  id        VARCHAR(20),\n" +
                    "  patientId VARCHAR(30),\n" +
                    "  text      VARCHAR(300),\n" +
                    "  FOREIGN KEY (patientId) REFERENCES users (id),\n" +
                    "  PRIMARY KEY (id)\n" +
                    ");");


            System.out.println("Database initialized successfully");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void resetDatabase() {
        Connection con = null;
        Statement stmt = null;

        try {
            initDriver();
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            stmt.executeUpdate("DROP TABLE enrollment;");
            stmt.executeUpdate("DROP TABLE student;");
            stmt.executeUpdate("DROP TABLE course;");
            System.out.println("Database reset successfully");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private static void initDriver() {
        if (driver == null) {
            try {
                driver = Class.forName("org.hsqldb.jdbc.JDBCDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

