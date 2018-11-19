/**
 * @(#) TherapyDAO.java
 */

package his.sequence.diagrams;


import his.Medicine;
import his.Therapy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class TherapyDAO
{
	public boolean isTherapyAvailable(LocalDateTime startDate, LocalDateTime endDate )
	{
		return false;
	}

	public String bookTherapy( LocalDateTime startTime, LocalDateTime endTime )
	{
		return null;
	}

	public Collection getAllTherapies(String folderId )
	{
		return null;
		/**try (Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
		 PreparedStatement stmt = con.prepareStatement("SELECT * FROM therapy WHERE FOLDER = ?")) {
		 stmt.setInt(1, Integer.parseInt(folderId));
		 try (ResultSet resultSet = stmt.executeQuery()) {
		 System.out.println();
		 Collection<Medicine> medicineCollection = new ArrayList<>();
		 while (resultSet.next()) {
		 Therapy medicine = new Therapy();
		 medicine.setName(resultSet.getString("name"));
		 medicine.setCode(resultSet.getString("code"));
		 medicine.setPharmaceuticalCompany(resultSet.getString("pharmaceuticalcompany"));

		 medicineCollection.add(medicine);
		 }
		 return  medicineCollection;
		 }
		 } catch ( Exception e) {throw new RuntimeException(e);}
		 */
	}


}
