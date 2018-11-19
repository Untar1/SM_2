/**
 * @(#) SurgeryController.java
 */

package his.sequence.diagrams;

import his.Surgeon;
import his.implementation.HasBoundary;

import java.time.LocalDateTime;
import java.util.Collection;

public class SurgeryController implements HasBoundary
{
    private Boundary boundary;

	public String bookSurgery(String patientId, LocalDateTime date, Surgeon surgeon )
	{
		return null;
	}
	
	public boolean setSurgeonTeam( String surgeonId, LocalDateTime dateTime, Collection teamList )
	{
		return false;
	}
	
	public boolean isInAllowedPeriod( LocalDateTime curr, LocalDateTime surgDate )
	{
		return false;
	}


    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
