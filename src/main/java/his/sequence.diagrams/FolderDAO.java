/**
 * @(#) FolderDAO.java
 */

package his.sequence.diagrams;

import his.Date;
import his.Folder;

public class FolderDAO
{
	public String getPatientFolderId( String patientId )
	{
		return null;
	}
	
	public boolean addTherapy( String folderId, String therapyId )
	{
		return false;
	}
	
	public Folder getPatientFolder( String patientId )
	{
		return null;
	}
	
	public boolean addSurgery( Folder folder, String surgeryId )
	{
		return false;
	}
	
	public boolean folderForPatientExists( String idCode )
	{
		return false;
	}
	
	public boolean createFolder( String name, String surname, String idCode, Date dateOfBirth, String insuranceCode )
	{
		return false;
	}
	
	public boolean setOncologist( String patientId, String oncologistId )
	{
		return false;
	}
	
	public boolean setVisit( String patientId, String visitId )
	{
		return false;
	}
	
	
}
