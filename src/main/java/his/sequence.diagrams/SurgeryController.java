/**
 * @(#) SurgeryController.java
 */

package his.sequence.diagrams;

import his.Folder;
import his.Surgeon;
import his.implementation.HasBoundary;

import java.time.LocalDateTime;
import java.util.Collection;

public class SurgeryController implements HasBoundary
{
    private Boundary boundary;
    private SurgeryDAO surgeryDAO;
    private UserDAO userDAO;
    private FolderDAO folderDAO;

	public String bookSurgery(String patientId, LocalDateTime date, Surgeon surgeon )
	{
        if (!boundary.getCurrentUserRole().equalsIgnoreCase("Oncologist")) {
            boundary.error("Not enough permissions");
        }
        String surgeonId = surgeon.getId();
        if (!userDAO.patientWithIdExists(patientId)) boundary.error("Patient with ID '" + patientId + "' does not exist");
        if (!userDAO.surgeonWithIdExists(surgeonId)) boundary.error("Surgeon with ID '" + patientId + "' does not exist");
        if (!surgeryDAO.surgeonAvailable(surgeonId, date)) boundary.error("Surgeon not available");
        String surgeryId = surgeryDAO.bookSurgery(surgeonId, date);
        Folder folder = folderDAO.getPatientFolder(patientId);
        folderDAO.addSurgery(folder, surgeryId);

		return surgeryId;
	}
	
	public boolean setSurgeonTeam( String surgeonId, LocalDateTime dateTime, Collection teamList )
	{
        if (!boundary.getCurrentUserRole().equalsIgnoreCase("Surgeon")) {
            boundary.error("Not enough permissions");
        }
        if (surgeryDAO.getSurgeryId(surgeonId, dateTime) == null) boundary.error("Surgery does not exist");

	    return false;
	}
	
	public boolean isInAllowedPeriod( LocalDateTime curr, LocalDateTime surgDate )
	{

	    return false;
	}

    public SurgeryController(SurgeryDAO surgeryDAO, UserDAO userDAO, FolderDAO folderDAO) {
        this.surgeryDAO = surgeryDAO;
        this.userDAO = userDAO;
        this.folderDAO = folderDAO;
    }

    public SurgeryController() {
        this.surgeryDAO = new SurgeryDAO();
        this.userDAO = new UserDAO();
        this.folderDAO = new FolderDAO();
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
