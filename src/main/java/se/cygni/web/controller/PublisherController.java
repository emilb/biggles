package se.cygni.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import se.cygni.web.model.Publisher;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("api/publisher")
public class PublisherController {

    private JdbcTemplate jdbcTemplate;

    private static String SQL_ALL_PUBLISHERS =
        "SELECT * FROM SVFörlag ORDER BY SVFörlag";

    @Autowired
    public PublisherController(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Publisher> listPublishers() {

        return this.jdbcTemplate.query(SQL_ALL_PUBLISHERS, new PublisherMapper());
    }

    @RequestMapping("/id/{id}")
    @ResponseBody
    public Publisher byId(@PathVariable int id) {

        return this.jdbcTemplate.queryForObject("SELECT * FROM SVFörlag WHERE SVFörlagId = ?", new Object[] {id}, new PublisherMapper());
    }

    public final class PublisherMapper implements RowMapper<Publisher> {

        @Override
        public Publisher mapRow(ResultSet rs, int i) throws SQLException {
            return new Publisher(
                    rs.getInt("SVFörlagID"),
                    rs.getString("SVFörlag"),
                    rs.getString("SVkort")
                    );
        }
    }
}
