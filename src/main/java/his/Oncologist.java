/**
 * @(#) Oncologist.java
 */

package his;

public class Oncologist
{
	private String name;
	
	private String surname;

    public String getProfessionalID() {
        return professionalID;
    }

    public void setProfessionalID(String professionalID) {
        this.professionalID = professionalID;
    }

    private String professionalID;
	
	private OncologistType oncologistType;
	
	private Surgery surgery;
	
	public String getId( )
	{
		return professionalID;
	}

	public OncologistType getOncologistType() { return oncologistType;}
	
	
}
