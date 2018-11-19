/**
 * @(#) Therapy.java
 */

package his;

public abstract class Therapy
{
	private Medicine medicines;

	private Schedule schedule;

	private Folder folder;

	private Date startOfTherapy;

	private Date endOfTherapy;

	public void setMedicines(Medicine medicines) {
		this.medicines = medicines;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public void setStartOfTherapy(Date startOfTherapy) {
		this.startOfTherapy = startOfTherapy;
	}

	public void setEndOfTherapy(Date endOfTherapy) {
		this.endOfTherapy = endOfTherapy;
	}
}
