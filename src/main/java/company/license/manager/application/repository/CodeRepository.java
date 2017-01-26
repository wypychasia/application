package company.license.manager.application.repository;

import company.license.manager.application.data.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wypychasia on 24.01.2017.
 */
@Repository
public class CodeRepository {

    private final String CODE_DATA_SELECT_SQL_STATEMENT = "SELECT lm_code.codecontent, lm_code.productid, lm_code.stationid "
            + "FROM lm_code "
            + "WHERE lm_code.productid = ? ";

    private static final class CodeRowMapper implements RowMapper<Code>
    {
        @Override
        public Code mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            return new Code(rs.getString("codecontent"), rs.getInt("productid"),
                    rs.getInt("stationid"));
        }
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Code> getCodeContent(int programID)
    {
        return jdbcTemplate.query(CODE_DATA_SELECT_SQL_STATEMENT, new CodeRowMapper(), programID);
    }
}
