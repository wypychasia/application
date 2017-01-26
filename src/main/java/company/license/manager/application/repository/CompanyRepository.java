package company.license.manager.application.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import company.license.manager.application.data.CompanyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepository
{
	private final String COMPANY_DATA_SELECT_SQL_STATEMENT = "SELECT lm_company.companyname, lm_company.nipnumber, lm_company.vattaxpayer, "
			+ "lm_company.emailaddress, lm_company.addresscity, lm_company.addresspostalcode, lm_company.addressstreet, "
			+ "lm_company.addresshousenumber, lm_company.phonenumber, lm_company.comments, lm_company.licensenumber FROM lm_company, lm_user "
			+ "WHERE lm_user.login = ? AND lm_user.userid = lm_company.userid";
	
	private final String COMPANY_DATA_UPDATE_SQL_STATEMENT = "UPDATE lm_company SET companyname = ?, nipnumber = ?, vattaxpayer = ?, "
			+ "emailaddress = ?, addresscity = ?, addresspostalcode = ?, addressstreet = ?, "
			+ "addresshousenumber = ?, phonenumber = ?, comments = ?, licensenumber = ? "
			+ "WHERE userid = (SELECT userid FROM lm_user WHERE login = ?)";
	
	private static final class CompanyDataRowMapper implements RowMapper<CompanyData>
	{
		@Override
		public CompanyData mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			return new CompanyData(rs.getString("companyname"), rs.getString("nipnumber"), rs.getBoolean("vattaxpayer"),
					rs.getString("emailaddress"), rs.getString("addresscity"), rs.getString("addresspostalcode"), rs.getString("addressstreet"),
					rs.getString("addresshousenumber"), rs.getString("phonenumber"), rs.getString("comments"), rs.getString("licensenumber"));
		}
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CompanyData getCompanyData(String userName)
	{
		return jdbcTemplate.query(COMPANY_DATA_SELECT_SQL_STATEMENT, new CompanyDataRowMapper(), userName).get(0);
	}
	
	public void updateCompanyData(CompanyData companyData, String userName)
	{
		jdbcTemplate.update(COMPANY_DATA_UPDATE_SQL_STATEMENT, companyData.getCompanyName(), companyData.getNIPNumber(), companyData.getVATTaxPayer(),
				companyData.getEmailAddress(), companyData.getAddressCity(), companyData.getAddressPostalCode(), companyData.getAddressStreet(),
				companyData.getAddressHouseNumber(), companyData.getPhoneNumber(), companyData.getComments(), companyData.getLicenseNumber(), userName);
	}
}
