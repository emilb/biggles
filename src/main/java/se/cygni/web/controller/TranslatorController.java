package se.cygni.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import se.cygni.web.model.Illustrator;
import se.cygni.web.model.Translator;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("api/translator")
public class TranslatorController {

    private JdbcTemplate jdbcTemplate;

    private static String SQL_ALL_TRANSLATORS =
        "SELECT * FROM Översättare ORDER BY Efternamn";

    @Autowired
    public TranslatorController(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

        // Warmup (database isn't populated until the first request)
        listTranslators();
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Translator> listTranslators() {

        return this.jdbcTemplate.query(SQL_ALL_TRANSLATORS, new TranslatorMapper());
    }

    @RequestMapping("/id/{id}")
    @ResponseBody
    public Translator byId(@PathVariable int id) {

        return this.jdbcTemplate.queryForObject("SELECT * FROM Översättare WHERE ÖversättareID = ?", new Object[] {id}, new TranslatorMapper());
    }

    public final class TranslatorMapper implements RowMapper<Translator> {

        @Override
        public Translator mapRow(ResultSet rs, int i) throws SQLException {
            return new Translator(
                    rs.getInt("ÖversättareID"),
                    rs.getString("Förnamn") + " " + rs.getString("Efternamn")
                    );
        }
    }
}
