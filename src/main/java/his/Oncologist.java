/**
 * @(#) Oncologist.java
 */

package his;

public class Oncologist
{
	private String name;
	
	private String surname;
	
	private String professionalID;
	
	private OncologistType oncologistType;
	
	private Surgery surgery;
	
	public String getId( )
	{
		return professionalID;
	}

	public OncologistType getOncologistType() { return oncologistType;}
	
	
}
