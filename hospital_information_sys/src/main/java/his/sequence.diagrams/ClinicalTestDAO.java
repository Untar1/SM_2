/**
 * @(#) ClinicalTestDAO.java
 */

package his.sequence.diagrams;

import his.DateTime;
import his.ImagingTest;

import java.util.Collection;

public class ClinicalTestDAO
{
	public boolean isTestAvailable( DateTime datetime, String testType )
	{
		return false;
	}
	
	public String bookTest( DateTime date, String testType, ImagingTest subTestType )
	{
		return null;
	}
	
	public String bookTest( DateTime datetime, String testType )
	{
		return null;
	}
	
	public Collection getAllClinicalTests(String folderId )
	{
		return null;
	}
	
	
}
