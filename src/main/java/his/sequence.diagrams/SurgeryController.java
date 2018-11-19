/**
 * @(#) SurgeryController.java
 */

package his.sequence.diagrams;

import his.DateTime;
import his.Surgeon;
import his.implementation.HasBoundary;

import java.util.Collection;

public class SurgeryController implements HasBoundary
{
    private Boundary boundary;

	public String bookSurgery( String patientId, DateTime date, Surgeon surgeon )
	{
		return null;
	}
	
	public boolean setSurgeonTeam( String surgeonId, DateTime dateTime, Collection teamList )
	{
		return false;
	}
	
	public boolean isInAllowedPeriod( DateTime curr, DateTime surgDate )
	{
		return false;
	}


    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
