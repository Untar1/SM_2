/**
 * @(#) AnamnesisController.java
 */

package his.sequence.diagrams;

import his.implementation.HasBoundary;

public class AnamnesisController implements HasBoundary {
    // TODO: Like this?
    private UserDAO userDAO = new UserDAO();
    private AnamnesisDAO anamnesisDAO = new AnamnesisDAO();

    private Boundary boundary;

    public String addAnamnesis(String patientId, String text) {
        if (!boundary.getCurrentUserRole().equalsIgnoreCase("Oncologist")) {
            boundary.error("Not enough permissions");
        }
        if (!userDAO.patientWithIdExists(patientId)) {
            boundary.error("Patient does not exist.");
        }

        return anamnesisDAO.createAnamnesis(patientId, text);
    }


    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
