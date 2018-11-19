/**
 * @(#) ClinicalTestDAO.java
 */

package his.sequence.diagrams;

<<<<<<< HEAD
import com.sun.org.apache.regexp.internal.RE;
import his.DatabaseManager;
=======
import his.ImagingTest;
>>>>>>> b91fd8e7cd12f1dc038616636cd77ba6f7f103e3
import his.TestType;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Collection;

public class ClinicalTestDAO
{
	public boolean isTestAvailable(LocalDateTime datetime, String testType )
	{
		return false;
	}

	public String bookTest( LocalDateTime date, String testType, TestType subTestType )
	{
		try (Connection con = DatabaseManager.getConnection()) {
            return "";
        } catch (Exception e) {
		    throw new RuntimeException(e);
        }
	}
	
	public String bookTest( LocalDateTime datetime, String testType )
	{
		return null;
	}
	
	public Collection getAllClinicalTests(String folderId )
	{
		return null;
	}
	
	
}
