/**
 * @(#) FolderController.java
 */

package his.sequence.diagrams;

import his.Medicine;
import his.dateTime;
import his.Date;
import his.Folder;

import java.util.Collection;

public class FolderController
{
    // TODO: Like this?
    private TherapyDAO therapyDAO = new TherapyDAO();
    private Boundary boundary = new Boundary();
    private FolderDAO folderDAO = new FolderDAO();
    private TherapyMedicineDAO therapyMedicineDAO = new TherapyMedicineDAO();
    private MedicineDAO medicineDAO = new MedicineDAO();

	public String addTherapy( String patientId, dateTime startDate, dateTime endDate )
	{
        if (!boundary.getCurrentUserRole().equalsIgnoreCase("Oncologist")) boundary.error("Not enough permissions");
        if (folderDAO.getPatientFolderId(patientId) == null) boundary.error("Patient does not exist");
        if (!therapyDAO.isTherapyAvailable(startDate, endDate)) boundary.error("Therapy not available");
        String therapyId = therapyDAO.bookTherapy(startDate, endDate);
        // TODO: Where does the patientFolerId come from?
        if (!folderDAO.addTherapy(patientId, therapyId)) boundary.error("Could not add therapy to patient's folder");
        Collection<Medicine> therapyMedicines = boundary.getMedicines();
        for (Medicine medicine : therapyMedicines) {
            String medicineId = medicine.getId();


        }

		return null;
	}
	
	public void openFolder( String name, String surname, String idCode, Date dateOfBirth, String insuranceCode )
	{
		
	}
	
	public boolean addOncologistToFolder( String patientId, String oncologistId )
	{
		return false;
	}
	
	public boolean setFirstVisitDate( String patientId, String oncologistId, dateTime dateTime )
	{
		return false;
	}
	
	public Folder getPatientFolder( String patientId )
	{
		return null;
	}
	
	
}
