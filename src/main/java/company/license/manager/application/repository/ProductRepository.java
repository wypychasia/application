package company.license.manager.application.repository;

import company.license.manager.application.data.OtherProductName;
import company.license.manager.application.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wypychasia on 21.01.2017.
 */
@Repository
public class ProductRepository{

    private final String PRODUCT_DATA_SELECT_SQL_STATEMENT = "SELECT lm_product.productname, lm_product.version, lm_product.productid, lm_product.stations "
            + "FROM lm_user, lm_company, lm_product "
            + "WHERE lm_user.login = ? AND lm_user.userid = lm_company.userid AND lm_company.companyid = lm_product.companyid ";

    private final String PRODUCT_DATA_UPDATE_SQL_STATEMENT_STATIONS = "UPDATE lm_product SET stations = stations + 1 "
            + "WHERE userid = (SELECT userid FROM lm_user WHERE login = ?) AND lm_user.userid = lm_company.userid AND lm_company.companyid = lm_product.companyid ";

    private final String PRODUCT_DATA_INSERT_SQL_STATEMENT = "INSERT INTO lm_product (productid, productname, version, companyid)  "
            + "VALUES (100, ?, ?, ?) ";


    private static final class ProductRowMapper implements RowMapper<Product>
    {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            return new Product(rs.getString("productname"), rs.getDouble("version"),
                    rs.getInt("productid"), rs.getInt("stations"));
        }
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getProductData(String userName)
    {
        return jdbcTemplate.query(PRODUCT_DATA_SELECT_SQL_STATEMENT, new ProductRowMapper(), userName);
    }
    public void updateStations(String userName)
    {
        jdbcTemplate.update(PRODUCT_DATA_UPDATE_SQL_STATEMENT_STATIONS, userName);
    }
    public void updateProductData(Product product, String userName)
    {
        jdbcTemplate.update(PRODUCT_DATA_INSERT_SQL_STATEMENT, product.getProductName(), product.getProductVersion(),
                product.getCompanyID());
    }

}