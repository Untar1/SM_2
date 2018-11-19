/**
 * @(#) ReportController.java
 */

package his.sequence.diagrams;

import his.implementation.HasBoundary;

public class ReportController implements HasBoundary
{
    private Boundary boundary;

	public void printReport( String patientId )
	{
		
	}


    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
