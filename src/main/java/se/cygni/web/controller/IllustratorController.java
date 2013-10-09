package se.cygni.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import se.cygni.web.model.Illustrator;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("api/illustrator")
public class IllustratorController {

    private JdbcTemplate jdbcTemplate;

    private static String SQL_ALL_ILLUSTRATORS =
            "SELECT * FROM Illustratörer ORDER BY Efternamn";

    @Autowired
    public IllustratorController(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

        // Warmup (database isn't populated until the first request)
        listIllustrators();
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Illustrator> listIllustrators() {

        return this.jdbcTemplate.query(SQL_ALL_ILLUSTRATORS, new IllustratorMapper());
    }

    @RequestMapping("/id/{id}")
    @ResponseBody
    public Illustrator byId(@PathVariable int id) {

        return this.jdbcTemplate.queryForObject("SELECT * FROM Illustratörer WHERE IllustratörID = ?", new Object[]{id}, new IllustratorMapper());
    }

    public final class IllustratorMapper implements RowMapper<Illustrator> {

        @Override
        public Illustrator mapRow(ResultSet rs, int i) throws SQLException {
            return new Illustrator(
                    rs.getInt("IllustratörID"),
                    rs.getString("Förnamn") + " " + rs.getString("Efternamn")
            );
        }
    }
}
