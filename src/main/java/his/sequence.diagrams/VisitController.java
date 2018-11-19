/**
 * @(#) VisitController.java
 */

package his.sequence.diagrams;

import his.Oncologist;
import his.implementation.HasBoundary;

import java.time.LocalDateTime;

public class VisitController implements HasBoundary
{
    private Boundary boundary;

	public String bookTest(String patiendId, LocalDateTime datetime, String testType )
	{
		return null;
	}
	
	public String bookVisit( LocalDateTime dateTime, Oncologist oncologist, boolean isFirstVisit )
	{
		return null;
	}


    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
