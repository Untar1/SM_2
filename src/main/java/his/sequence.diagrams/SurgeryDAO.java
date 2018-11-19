/**
 * @(#) SurgeryDAO.java
 */

package his.sequence.diagrams;


import java.time.LocalDateTime;
import java.util.Collection;

public class SurgeryDAO
{
	public boolean surgeonAvailable( String surgeonId, LocalDateTime date )
	{
		return false;
	}
	
	public String bookSurgery( String surgeonId, LocalDateTime date )
	{
		return null;
	}
	
	public Collection getSurgeries(String folderId )
	{
		return null;
	}
	
	public String getSurgeryId( String surgeonId, LocalDateTime date )
	{
		return null;
	}
	
	public boolean isOncologistAvailable( LocalDateTime date, String id )
	{
		return false;
	}
	
	public boolean addAsTeamMember( String surgId, String oncId )
	{
		return false;
	}
	
	
}
