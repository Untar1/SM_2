/**
 * @(#) UserController.java
 */

package his.sequence.diagrams;

import java.util.Collection;

public class UserController
{
	public String addNewDoctor( String professionalId, String name, String surname, String type, String subType )
	{
		return null;
	}
	
	public boolean login( String username, String password )
	{
		return false;
	}
	
	public boolean registerUser( String username, String password, String role )
	{
	    UserDAO userDAO = new UserDAO();
		boolean userExists = userDAO.userWithUsernameExists(username);
		if (userExists) return  true;
		return userDAO.createUser(username, password, role);
	}
	
	public Collection getAllPatients( )
	{
		return null;
	}
	
	public Collection getAllDoctors( String docType )
	{
		return null;
	}
	
	
}
