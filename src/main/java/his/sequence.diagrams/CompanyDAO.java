/**
 * @(#) CompanyDAO.java
 */

package his.sequence.diagrams;

import his.DatabaseManager;
import his.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDAO
{
	public String getCompanyId( String companyName )
	{
		try (Connection conn = DatabaseManager.getConnection();
			 PreparedStatement statement = conn.prepareStatement("SELECT * FROM COMPANY WHERE NAME = ?")) {
			statement.setString(1, companyName);
			try (ResultSet resultSet = statement.executeQuery()) {
				return resultSet.getString("id");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
