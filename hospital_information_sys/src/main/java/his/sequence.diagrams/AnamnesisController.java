/**
 * @(#) AnamnesisController.java
 */

package his.sequence.diagrams;

public class AnamnesisController
{
    // TODO: Like this?
    private UserDAO userDAO = new UserDAO();
    private Boundary boundary = new Boundary();
    private AnamnesisDAO anamnesisDAO = new AnamnesisDAO();

	public String addAnamnesis( String patientId, String text )
	{
		if (!boundary.getCurrentUserRole().equalsIgnoreCase("Oncologist")) return boundary.error("Not enough permissions");
		if (!userDAO.patientWithIdExists(patientId)) return  boundary.error("Patient does not exist.");

		return anamnesisDAO.createAnamnesis(patientId, text);
	}
	
	
}
