/**
 * @(#) ClinicalTestDAO.java
 */

package his.sequence.diagrams;

import his.ImagingTest;
import his.TestType;

import java.time.LocalDateTime;
import java.util.Collection;

public class ClinicalTestDAO
{
	public boolean isTestAvailable(LocalDateTime datetime, String testType )
	{
		return false;
	}

	// TODO: in this case, we are dealing with ImagingTest type
	public String bookTest( LocalDateTime date, String testType, TestType subTestType )
	{
		return null;
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
