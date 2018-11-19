/**
 * @(#) SurgeryController.java
 */

package his.sequence.diagrams;

import his.Folder;
import his.Oncologist;
import his.Surgeon;
import his.implementation.HasBoundary;
import his.implementation.Roles;

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
        if (!boundary.getCurrentUserRole().equalsIgnoreCase(Roles.ROLE_ONCOLOGIST)) {
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
	
	public boolean setSurgeonTeam( String surgeonId, LocalDateTime dateTime, Collection<Oncologist> teamList )
	{
        if (!boundary.getCurrentUserRole().equals(Roles.ROLE_SURGEON)) {
            boundary.error("Not enough permissions");
        }
        String surgeryId = surgeryDAO.getSurgeryId(surgeonId, dateTime);
        if (surgeryId == null) boundary.error("Surgery does not exist");
        LocalDateTime currentDate = boundary.getCurrentDate();
        if (!isInAllowedPeriod(currentDate, dateTime)) boundary.error("Cannot modify the team");
        for (Oncologist oncologist : teamList) {
            if (userDAO.getOncologist(oncologist.getId()) == null) boundary.error("Oncologist does not exist");
            if (!surgeryDAO.isOncologistAvailable(dateTime, oncologist.getId())) boundary.error("Oncologist is not available");
            if (!surgeryDAO.addAsTeamMember(surgeryId, oncologist.getId())) boundary.error("Failed to add oncologist as a member");

        }
        return true;
	}
	
	public boolean isInAllowedPeriod( LocalDateTime curr, LocalDateTime surgDate )
	{
        int diff = surgDate.getDayOfYear() - curr.getDayOfYear();
        if ((diff <= 7) && (diff >=5) || diff == 358 || diff == 359) return true;
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
