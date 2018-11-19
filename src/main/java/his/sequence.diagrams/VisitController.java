/**
 * @(#) VisitController.java
 */

package his.sequence.diagrams;

import his.ImagingTest;
import his.Oncologist;
import his.TestType;
import his.implementation.HasBoundary;
import his.implementation.Roles;

import java.time.LocalDateTime;

public class VisitController implements HasBoundary
{
    private Boundary boundary;
    private UserDAO userDAO;
    private ClinicalTestDAO clinicalTestDAO;
    private VisitDAO visitDAO;

	public String bookTest(String patiendId, LocalDateTime datetime, String testType )
	{
        String currentUserRole = boundary.getCurrentUserRole();
        if (!currentUserRole.equals(Roles.ROLE_ONCOLOGIST)) {
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
        String currentUserRole = boundary.getCurrentUserRole();
        if (!currentUserRole.equals(Roles.ROLE_PRIV_DOC)) {
            boundary.error("Not enough permissions");
        }
        String oncologistId = oncologist.getId();
        if (!userDAO.oncologistWithIdExists(oncologistId)) boundary.error("Oncologist does not exist");
        if (!visitDAO.visitAvailable(oncologistId, dateTime)) boundary.error("Visit not available");
        String patientIdCode = "";
        if (isFirstVisit) {
            String patientName = boundary.getPatientName();
            String patientSurname = boundary.getPatientSurname();
            patientIdCode = boundary.getPatientIdCode();
            String patientInsuranceCode = boundary.getPatientInsuranceCode();

            if (userDAO.patientWithIdExists(patientIdCode)) boundary.error("Patient exists, but registered as first visit");
            userDAO.createPatient(patientName, patientSurname, patientIdCode, patientInsuranceCode);
        } else {
            patientIdCode = boundary.getPatientIdCode();
        }
        String visitId = visitDAO.createVisit(patientIdCode, dateTime);
        visitDAO.createVisit(oncologistId, dateTime);

        return visitId;
	}

    public VisitController(UserDAO userDAO, ClinicalTestDAO clinicalTestDAO, VisitDAO visitDAO) {
        this.userDAO = userDAO;
        this.clinicalTestDAO = clinicalTestDAO;
        this.visitDAO = visitDAO;
    }

    public VisitController() {
	    this.userDAO = new UserDAO();
	    this.clinicalTestDAO = new ClinicalTestDAO();
	    this.visitDAO = new VisitDAO();
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
