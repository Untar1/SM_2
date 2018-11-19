/**
 * @(#) AnamnesisDAO.java
 */

package his.sequence.diagrams;

import his.Anamnesis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AnamnesisDAO
{
	public String createAnamnesis( String patientId, String text )
	{
	    try {
            Anamnesis anamnesis = new Anamnesis();
            Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/universitydb", "SA", "");
            Statement stmt = con.createStatement();
            stmt.executeQuery("SELECT  TABLE student (studentID varchar(20) NOT NULL, PRIMARY KEY (studentID));");
            return null;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
	}
}
