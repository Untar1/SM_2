/**
 * @(#) Boundary.java
 */

package his.sequence.diagrams;

import his.dateTime;
import his.ImagingTest;

import java.util.Collection;

public class Boundary
{
	public String getCurrentUserRole( )
	{
		return null;
	}
	
	public void error( String message )
	{
	    Exception e = new Exception();
	    e.printStackTrace(System.out.printf(message));
	}
	
	public Collection getMedicines( )
	{
		return null;
	}
	
	public ImagingTest getSubTestType( )
	{
		return null;
	}
	
	public String getPatientName( )
	{
		return null;
	}
	
	public String getPatientSurname( )
	{
		return null;
	}
	
	public String getPatientIdCode( )
	{
		return null;
	}
	
	public String getPatientInsuranceCode( )
	{
		return null;
	}
	
	public dateTime getCurrentDate( )
	{
		return null;
	}

    public static void main(String[] args) {
        
    }
}
