/**
 * @(#) ReportController.java
 */

package his.sequence.diagrams;

import his.implementation.HasBoundary;
import his.implementation.Roles;

public class ReportController implements HasBoundary
{
    private Boundary boundary;
    private UserDAO userDAO;
    private ExternalSystemIntegration externalSystemIntegration;

	public void printReport( String patientId )
	{
        if (!boundary.getCurrentUserRole().equals(Roles.ROLE_ONCOLOGIST)) {
            boundary.error("Not enough permissions");
        }
        if (!userDAO.patientWithIdExists(patientId)) boundary.error("Patient with ID '" + patientId + "' does not exist");
        externalSystemIntegration.printTestResults(patientId);
	}

    public ReportController(UserDAO userDAO, ExternalSystemIntegration externalSystemIntegration) {
        this.userDAO = userDAO;
        this.externalSystemIntegration = externalSystemIntegration;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
