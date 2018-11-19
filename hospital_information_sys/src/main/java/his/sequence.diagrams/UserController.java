/**
 * @(#) UserController.java
 */

package his.sequence.diagrams;

import his.SurgeonType;

import java.util.Collection;

public class UserController
{
    // TODO: Like this?
    private UserDAO userDAO = new UserDAO();
    private Boundary boundary = new Boundary();

	public String addNewDoctor( String professionalId, String name, String surname, String type, SurgeonType subType )
	{
        String currentUserRole = boundary.getCurrentUserRole();
        if (!currentUserRole.equalsIgnoreCase("administrative officer")) return  boundary.error("Not enough permissions");
        boolean doctorwithIdExists = userDAO.doctorWIthIdExists(professionalId);
        if (doctorwithIdExists) return  boundary.error("Doctor with ID exists");
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
        if (!currentUserRole.equals("Receptionist")) return boundary.error("Not enough permissions");

	    return userDAO.getAllPatients();
	}
	
	public Collection getAllDoctors( String docType )
	{
		String currentUserRole = boundary.getCurrentUserRole();
		if (!currentUserRole.equalsIgnoreCase("administrative officer")) return  boundary.error("Not enough permissions");
	    return userDAO.getAllDoctors(docType);
	}
	
	
}
