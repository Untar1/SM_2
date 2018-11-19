/**
 * @(#) UserDAO.java
 */

package his.sequence.diagrams;

import his.Oncologist;
import his.Patient;
import his.SurgeonType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

public class UserDAO
{
	public boolean doctorWIthIdExists( String id )
	{
		return false;
	}
	
	public String createDoctor( String professionalId, String name, String surname, String type, String subType )
	{
		return null;
	}
	
	public boolean patientWithIdExists( String id )
	{
		return false;
	}
	
	public boolean surgeonWithIdExists( String id )
	{
		return false;
	}
	
	public Boolean getUserWithUsernameAndPassword( String username, String password )
	{
		return null;
	}
	
	public boolean oncologistWithIdExists( String oncologistId )
	{
		return false;
	}
	
	public void createPatient( String name, String surname, String idCode, String insuranceCode )
	{
		
	}
	
	public boolean userWithUsernameExists( String username )
	{
		return false;
	}
	
	public boolean createUser( String username, String password, String role )
	{
		return false;
	}
	
	public Patient getPatient( String patientId )
	{
		return null;
	}
	
	public Oncologist getSpecialist( String folderId )
	{
		return null;
	}
	
	public Collection getAllPatients( )
	{
		return null;
	}
	
	public Collection getAllDoctors( String docType )
	{
		return null;
	}
	
	public String getOncologist( String id )
	{
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
