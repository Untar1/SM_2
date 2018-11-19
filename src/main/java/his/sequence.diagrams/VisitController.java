/**
 * @(#) VisitController.java
 */

package his.sequence.diagrams;

import his.DateTime;
import his.Oncologist;
import his.implementation.HasBoundary;

public class VisitController implements HasBoundary
{
    private Boundary boundary;

	public String bookTest( String patiendId, DateTime datetime, String testType )
	{
		return null;
	}
	
	public String bookVisit( DateTime dateTime, Oncologist oncologist, boolean isFirstVisit )
	{
		return null;
	}


    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
