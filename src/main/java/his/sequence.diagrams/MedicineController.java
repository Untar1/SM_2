/**
 * @(#) MedicineController.java
 */

package his.sequence.diagrams;

import his.Medicine;
import his.implementation.HasBoundary;

import java.util.ArrayList;
import java.util.Collection;

public class MedicineController implements HasBoundary
{
	private Boundary boundary;

    public String addMedicine( String name, String companyName )
	{
		return null;
	}

	public Collection<Medicine> getAllMedicines() {
        return new ArrayList<>();
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
