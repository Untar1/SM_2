/**
 * @(#) SurgeryDAO.java
 */

package his.sequence.diagrams;

import his.DateTime;

import java.util.Collection;

public class SurgeryDAO
{
	public boolean surgeonAvailable( String surgeonId, DateTime date )
	{
		return false;
	}
	
	public String bookSurgery( String surgeonId, DateTime date )
	{
		return null;
	}
	
	public Collection getSurgeries(String folderId )
	{
		return null;
	}
	
	public String getSurgeryId( String surgeonId, DateTime date )
	{
		return null;
	}
	
	public boolean isOncologistAvailable( DateTime date, String id )
	{
		return false;
	}
	
	public boolean addAsTeamMember( String surgId, String oncId )
	{
		return false;
	}
	
	
}
