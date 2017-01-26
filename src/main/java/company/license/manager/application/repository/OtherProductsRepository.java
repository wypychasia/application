package company.license.manager.application.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import company.license.manager.application.data.OtherProductName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OtherProductsRepository
{
	private final String OTHER_PRODUCT_DATA_SELECT_SQL_STATEMENT = "SELECT lm_product.productname "
			+ "FROM lm_user, lm_company, lm_product "
			+ "WHERE lm_user.login = ? AND lm_user.userid = lm_company.userid AND lm_company.companyid = lm_product.companyid";
	
	private static final class OtherProductNameRowMapper implements RowMapper<OtherProductName>
	{
		@Override
		public OtherProductName mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			// TODO Auto-generated method stub
			return new OtherProductName(rs.getString("productname"));
		}
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<OtherProductName> checkProductsOwnership(String userName)
	{
		return jdbcTemplate.query(OTHER_PRODUCT_DATA_SELECT_SQL_STATEMENT, new OtherProductNameRowMapper(), userName);
	}
}
