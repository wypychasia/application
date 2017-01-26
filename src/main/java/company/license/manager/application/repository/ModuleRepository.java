package company.license.manager.application.repository;

import company.license.manager.application.data.ProgramModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wypychasia on 22.01.2017.
 */
@Repository
public class ModuleRepository {

    private final String MODULE_DATA_SELECT_SQL_STATEMENT = "SELECT lm_module.modulename, lm_module.productid "
            + "FROM lm_module "
            + "WHERE lm_module.productid = ? ";

    private static final class ModuleRowMapper implements RowMapper<ProgramModule>
    {
        @Override
        public ProgramModule mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            return new ProgramModule(rs.getString("modulename"), rs.getInt("productid"));
        }
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProgramModule> getModuleData(int productId)
    {
        return jdbcTemplate.query(MODULE_DATA_SELECT_SQL_STATEMENT, new ModuleRowMapper(), productId);
    }

}
