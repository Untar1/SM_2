/**
 * @(#) UserController.java
 */

package his.sequence.diagrams;

import his.implementation.HasBoundary;
import his.implementation.Roles;

import java.util.Collection;

public class UserController implements HasBoundary
{
    // TODO: Like this?
    private UserDAO userDAO = new UserDAO();
    private Boundary boundary;

	public String addNewDoctor( String professionalId, String name, String surname, String type, String subType )
	{
        String currentUserRole = boundary.getCurrentUserRole();
        if (!currentUserRole.equalsIgnoreCase(Roles.ROLE_ADMIN)) {
            boundary.error("Not enough permissions");
        }
        boolean doctorwithIdExists = userDAO.doctorWIthIdExists(professionalId);
        if (doctorwithIdExists) {
            boundary.error("Doctor with ID exists");
        }
		return userDAO.createDoctor(professionalId, name, surname, type, subType);
	}
	
	public boolean login( String username, String password )
	{

	    return userDAO.getUserWithUsernameAndPassword(username, password) != null;
	}
	
	public boolean registerUser( String username, String password, String role )
	{
		boolean userExists = userDAO.userWithUsernameExists(username);
		if (userExists) return  true;
		return userDAO.createUser(username, password, role);
	}
	
	public Collection getAllPatients( )
	{
        // TODO: How to parse error msgs?
	    String currentUserRole = boundary.getCurrentUserRole();
        if (!currentUserRole.equals(Roles.ROLE_RECEPTIONIST)) {
            boundary.error("Not enough permissions");
        }

	    return userDAO.getAllPatients();
	}
	
	public Collection getAllDoctors( String docType )
	{
		String currentUserRole = boundary.getCurrentUserRole();
		if (!currentUserRole.equalsIgnoreCase(Roles.ROLE_ADMIN)) {
		    boundary.error("Not enough permissions");
        }

	    return userDAO.getAllDoctors(docType);
	}


    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
