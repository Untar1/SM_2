/**
 * @(#) VisitController.java
 */

package his.sequence.diagrams;

import his.ImagingTest;
import his.Oncologist;
import his.TestType;
import his.implementation.HasBoundary;

import java.time.LocalDateTime;

public class VisitController implements HasBoundary
{
    private Boundary boundary;
    private UserDAO userDAO;
    private ClinicalTestDAO clinicalTestDAO;
    private VisitDAO visitDAO;

	public String bookTest(String patiendId, LocalDateTime datetime, String testType )
	{
        if (!boundary.getCurrentUserRole().equalsIgnoreCase("Oncologist")) {
            boundary.error("Not enough permissions");
        }
        if (!userDAO.patientWithIdExists(patiendId)) boundary.error("Patient does not exist");
        if (!clinicalTestDAO.isTestAvailable(datetime, testType)) boundary.error("Test not available at specified date and time");
        String testId;
        if (testType.equalsIgnoreCase("imaging")) {
            TestType testSubType = boundary.getSubTestType();

            testId = clinicalTestDAO.bookTest(datetime, testType, testSubType);
        } else {
            testId = clinicalTestDAO.bookTest(datetime, testType);
        }
        String visitId = visitDAO.createVisit(patiendId, datetime);
        visitDAO.setClinicalTest(visitId, testId);
		return visitId;
	}
	
	public String bookVisit( LocalDateTime dateTime, Oncologist oncologist, boolean isFirstVisit )
	{
		return null;
	}

    public VisitController(UserDAO userDAO, ClinicalTestDAO clinicalTestDAO, VisitDAO visitDAO) {
        this.userDAO = userDAO;
        this.clinicalTestDAO = clinicalTestDAO;
        this.visitDAO = visitDAO;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
