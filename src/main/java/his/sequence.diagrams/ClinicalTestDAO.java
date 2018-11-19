/**
 * @(#) ClinicalTestDAO.java
 */

package his.sequence.diagrams;

import his.ImagingTest;

import java.time.LocalDateTime;
import java.util.Collection;

public class ClinicalTestDAO
{
	public boolean isTestAvailable(LocalDateTime datetime, String testType )
	{
		return false;
	}
	
	public String bookTest( LocalDateTime date, String testType, ImagingTest subTestType )
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
