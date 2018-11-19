/**
 * @(#) FolderController.java
 */

package his.sequence.diagrams;

import his.DateTime;
import his.Date;
import his.Folder;

public class FolderController
{
	public String addTherapy( String patientId, DateTime startDate, DateTime endDate )
	{
		return null;
	}
	
	public void openFolder( String name, String surname, String idCode, Date dateOfBirth, String insuranceCode )
	{
		
	}
	
	public boolean addOncologistToFolder( String patientId, String oncologistId )
	{
		return false;
	}
	
	public boolean setFirstVisitDate( String patientId, String oncologistId, DateTime dateTime )
	{
		return false;
	}
	
	public Folder getPatientFolder( String patientId )
	{
		return null;
	}
	
	
}
