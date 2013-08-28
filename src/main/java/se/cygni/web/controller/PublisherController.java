package se.cygni.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import se.cygni.web.model.Publisher;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/publisher")
public class PublisherController {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherController(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Publisher> listPublishers() {

        List<Publisher> publishers = new ArrayList<Publisher>();
        publishers.add(new Publisher(1, "Bonniers", "Bonniers Ö N F"));
        publishers.add(new Publisher(2, "Bonniers", "Bonniers Ö N F"));

        return publishers;
    }
}
