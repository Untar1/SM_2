/**
 * @(#) MedicineController.java
 */

package his.sequence.diagrams;

import his.Medicine;
import his.implementation.HasBoundary;
import his.implementation.Roles;

import java.util.Collection;

public class MedicineController implements HasBoundary
{
	private Boundary boundary;
	private CompanyDAO companyDAO;
	private MedicineDAO medicineDAO;

    public String addMedicine( String name, String companyName )
	{
        if (!boundary.getCurrentUserRole().equals(Roles.ROLE_ONCOLOGIST)) {
            boundary.error("Not enough permissions");
        }
        String companyId = companyDAO.getCompanyId(companyName);
        if (companyId == null)  boundary.error("Company with such name does not exist");

        return medicineDAO.addMedicine(companyId, name);
	}

	public Collection<Medicine> getAllMedicines() {
        String currentUserRole = boundary.getCurrentUserRole();
        if (!currentUserRole.equalsIgnoreCase(Roles.ROLE_ONCOLOGIST)) {
            boundary.error("Not enough permissions");
        }

        return medicineDAO.getAllMedicines();
    }

    public MedicineController(CompanyDAO companyDAO, MedicineDAO medicineDAO) {
        this.companyDAO = companyDAO;
        this.medicineDAO = medicineDAO;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
