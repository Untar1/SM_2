/**
 * @(#) ImagingTest.java
 */

package his;

public class ImagingTest extends ClinicalTest
{
	private TestType type;
	
	private Visit visit;

	public ImagingTest(TestType type, Visit visit) {
		this.type = type;
		this.visit = visit;
	}
}
