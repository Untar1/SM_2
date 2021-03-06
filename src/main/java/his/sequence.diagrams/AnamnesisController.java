/**
 * @(#) AnamnesisController.java
 */

package his.sequence.diagrams;

import his.implementation.HasBoundary;
import his.implementation.Roles;

public class AnamnesisController implements HasBoundary {
    // TODO: Like this?
    private UserDAO userDAO;
    private AnamnesisDAO anamnesisDAO;

    private Boundary boundary;

    public String addAnamnesis(String patientId, String text) {
        if (!boundary.getCurrentUserRole().equalsIgnoreCase(Roles.ROLE_ONCOLOGIST)) {
            boundary.error("Not enough permissions");
        }
        if (!userDAO.patientWithIdExists(patientId)) {
            boundary.error("Patient does not exist.");
        }

        return anamnesisDAO.createAnamnesis(patientId, text);
    }

    public AnamnesisController(UserDAO userDAO, AnamnesisDAO anamnesisDAO) {
        this.userDAO = userDAO;
        this.anamnesisDAO = anamnesisDAO;
    }

    public AnamnesisController() {
        this.userDAO = new UserDAO();
        this.anamnesisDAO = new AnamnesisDAO();
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
