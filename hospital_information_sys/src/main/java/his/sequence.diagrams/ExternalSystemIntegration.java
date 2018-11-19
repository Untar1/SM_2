/**
 * @(#) ExternalSystemIntegration.java
 */

package his.sequence.diagrams;

public final class ExternalSystemIntegration
{
    private static ExternalSystemIntegration integration = new ExternalSystemIntegration();

    private ExternalSystemIntegration() {

    }

    public static ExternalSystemIntegration getInstance() {
        return integration;
    }

	public boolean printTestResults( String patientId )
	{
		return false;
	}

}
