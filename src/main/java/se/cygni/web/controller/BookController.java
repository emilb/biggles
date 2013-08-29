package se.cygni.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import se.cygni.web.model.Book;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("api/book")
public class BookController {

    private JdbcTemplate jdbcTemplate;

    private static String SQL_ALL_BOOKS =
            "SELECT " +
                "Böcker.BokID, " +
                "Böcker.SV1upplaga, " +
                "Böcker.DennaUpplaga, " +
                "Böcker.AntalUpplagor, " +
                "Böcker.RyggNr, " +
                "Böcker.Konvelut, " +
                "Böcker.Handling, " +
                "Författare.Efternamn as FörfattareEfternamn, " +
                "Författare.Förnamn as FörfattareFörnamn, " +
                "Titlar.TitelSV, " +
                "Titlar.TitelENG, " +
                "Titlar.ENG1upplaga, " +
                "Titlar.Chrono, " +
                "Illustratörer.Efternamn as IllustratörEfternamn, " +
                "Illustratörer.Förnamn as IllustratörFörnamn, " +
                "Översättare.Efternamn as ÖversättareEfternamn, " +
                "Översättare.Förnamn as ÖversättareFörnamn, " +
                "EngFörlag.ENGFörlag, " +
                "EngFörlag.ENGkort, " +
                "SVFörlag.SVFörlag, " +
                "SVFörlag.SVkort, " +
                "RevÖversättare.Efternamn as RevÖversättareEfternamn, " +
                "RevÖversättare.Förnamn as RevÖversättareFörnamn " +
            "FROM " +
                "Författare Författare, " +
                "Titlar Titlar, " +
                "Illustratörer Illustratörer, " +
                "Böcker Böcker, " +
                "`Översättare` Översättare, " +
                "EngFörlag EngFörlag, " +
                "SVFörlag SVFörlag, " +
                "`Översättare` RevÖversättare " +
            "WHERE " +
                "Böcker.TitelID = Titlar.TitelID AND " +
                "Böcker.FörfattareID = Författare.FörfattareID AND " +
                "Böcker.SVFörlag = SVFörlag.SVFörlagID AND " +
                "Böcker.`ÖversättareID` = Översättare.ÖversättareID AND " +
                "Böcker.RevÖversättareID = RevÖversättare.ÖversättareID AND " +
                "Böcker.IllustratörID = Illustratörer.IllustratörID AND " +
                "Titlar.ENGFörlag = EngFörlag.ENGFörlagID ";

    @Autowired
    public BookController(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @RequestMapping("id/{id}")
    @ResponseBody
    public Book byId(@PathVariable String id) {

        return null;
        //return this.jdbcTemplate.queryForList("select distinct TitelSV from Titlar order by TitelSV asc", String.class);
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Book> listBooks() {
        return this.jdbcTemplate.query(SQL_ALL_BOOKS, new BookMapper());
    }

    @RequestMapping("search/title/{term}")
    @ResponseBody
    public List<Book> searchBooks(@PathVariable String term) {
        return this.jdbcTemplate.query(createQuery("Titlar.TitelSV", term, true), new BookMapper());
    }

    @RequestMapping("list/title")
    @ResponseBody
    public List<String> listTitles() {
        return this.jdbcTemplate.queryForList("select distinct TitelSV from Titlar order by TitelSV asc", String.class);
    }

    private String createQuery(String column, String param, boolean isLike) {
        return SQL_ALL_BOOKS + "AND " + column + " LIKE '%" + param + "%'";
    }

    public final class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            return new Book(
                    rs.getInt("BokID"),
                    rs.getString("TitelSV"),
                    rs.getString("TitelEng"),
                    rs.getString("FörfattareFörnamn") + " " + rs.getString("FörfattareEfternamn"),
                    rs.getString("ÖversättareFörnamn") + " " + rs.getString("ÖversättareEfternamn"),
                    rs.getString("SVFörlag"),
                    rs.getString("ENGFörlag"),
                    rs.getString("SV1Upplaga"),
                    rs.getString("ENG1upplaga"),
                    rs.getString("DennaUpplaga"),
                    rs.getString("AntalUpplagor"),
                    rs.getString("RyggNr"),
                    rs.getBoolean("Konvelut"),
                    rs.getString("Handling"),
                    null, //coverImagePath
                    rs.getInt("Chrono")
                    );
        }
    }
}
