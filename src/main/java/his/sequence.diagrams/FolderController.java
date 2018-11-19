/**
 * @(#) FolderController.java
 */

package his.sequence.diagrams;

import his.*;
import his.implementation.HasBoundary;

import java.util.Collection;

public class FolderController implements HasBoundary
{
    // TODO: Like this?
    private TherapyDAO therapyDAO;
    private Boundary boundary;
    private FolderDAO folderDAO;
    private TherapyMedicineDAO therapyMedicineDAO;
    private MedicineDAO medicineDAO;
    private UserDAO userDAO;
    private VisitDAO visitDAO;
    private SurgeryDAO surgeryDAO;
    private ClinicalTestDAO clinicalTestDAO;


    public String addTherapy( String patientId, DateTime startDate, DateTime endDate )
	{
        if (!boundary.getCurrentUserRole().equalsIgnoreCase("Oncologist")) boundary.error("Not enough permissions");
        String patientFolderId = folderDAO.getPatientFolderId(patientId);
        if (patientFolderId == null) boundary.error("Patient does not exist");
        if (!therapyDAO.isTherapyAvailable(startDate, endDate)) boundary.error("Therapy not available");
        String therapyId = therapyDAO.bookTherapy(startDate, endDate);
        // TODO: Where does the patientFolerId come from?
        if (!folderDAO.addTherapy(patientFolderId, therapyId)) boundary.error("Could not add therapy to patient's folder");
        Collection<Medicine> therapyMedicines = boundary.getMedicines();
        for (Medicine medicine : therapyMedicines) {
            String medicineId = medicine.getId();
            if (!medicineDAO.medicineWithIdExists(medicineId)) boundary.error("Medicine with ID '" + medicineId + "' does not exit!");
            if (!therapyMedicineDAO.addMedicineToTherapy(therapyId, medicineId)) boundary.error("Could not add medicine with ID '" +
                    medicineId + "' to therapy with ID '" + therapyId + "'.");


        }
        return therapyId;
	}
	
	public boolean openFolder( String name, String surname, String idCode, Date dateOfBirth, String insuranceCode )
	{
		if (!boundary.getCurrentUserRole().equals("Receptionist")) boundary.error("Not enough permissions");
		if (folderDAO.folderForPatientExists(idCode)) boundary.error("Folder for patient already exists");
		return folderDAO.createFolder(name, surname, idCode,dateOfBirth, insuranceCode);
	}
	
	public boolean addOncologistToFolder( String patientId, String oncologistId )
	{
		if (!userDAO.oncologistWithIdExists(oncologistId)) boundary.error("Oncologist does not exits");
		return folderDAO.setOncologist(patientId, oncologistId);
	}
	
	public boolean setFirstVisitDate( String patientId, String oncologistId, DateTime dateTime )
	{
	    if (!userDAO.oncologistWithIdExists(oncologistId)) boundary.error("Oncologist does not exits");
	    if (!visitDAO.visitAvailable(oncologistId, dateTime)) boundary.error("Visit not available");
	    String visitId = visitDAO.createVisit(patientId, dateTime);
	    return folderDAO.setVisit(patientId, visitId);
	}
	
	public Folder getPatientFolder( String patientId )
	{
        if (!boundary.getCurrentUserRole().equals("Oncologist")) boundary.error("Not enough permissions");
        Folder patientFolder = folderDAO.getPatientFolder(patientId);
        String patientFolderId = patientFolder.getId();
        Collection<Surgery> surgeryList = surgeryDAO.getSurgeries(patientFolderId);
        patientFolder.setSurgeries(surgeryList);
        patientFolder.setPatient(userDAO.getPatient(patientId));
        patientFolder.setSpecialist(userDAO.getSpecialist(patientFolderId));
        patientFolder.setTherapies(therapyDAO.getAllTherapies(patientFolderId));
        patientFolder.setClinicalTests(clinicalTestDAO.getAllClinicalTests(patientFolderId));

		return patientFolder;
	}

	public FolderController(TherapyDAO therapyDAO, FolderDAO folderDAO, TherapyMedicineDAO therapyMedicineDAO
            , MedicineDAO medicineDAO, UserDAO userDAO, VisitDAO visitDAO, SurgeryDAO surgeryDAO, ClinicalTestDAO clinicalTestDAO) {
		this.therapyDAO = therapyDAO;
		this.folderDAO = folderDAO;
		this.therapyMedicineDAO = therapyMedicineDAO;
		this.medicineDAO = medicineDAO;
        this.userDAO = userDAO;
        this.visitDAO = visitDAO;
        this.surgeryDAO = surgeryDAO;
        this.clinicalTestDAO = clinicalTestDAO;
	}

	public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
