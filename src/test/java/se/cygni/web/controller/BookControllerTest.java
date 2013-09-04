package se.cygni.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.cygni.web.model.Book;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookControllerTest extends SpringBaseTest {

    @Autowired
    BookController bookController;

    @Test
    public void testById() throws Exception {

        Book expectedBook = new Book(
                3,
                "Biggles farligaste fiende",
                "Biggles in the blue",
                "W.E. Johns",
                "Anna-Lisa Olson",
                "Bertil Hegland",
                "B Wahlströms ungdomsböcker",
                "Brockhampton Press, Leicester",
                "1954",
                "1953",
                "1",
                "4, 1980",
                "731/732",
                false,
                null,
                "resources/images/covers/bwub/biggles_farligaste_fiende.jpg",
                50);
        Book book = bookController.byId(3);

        assertEquals("Book by ID did not match expected", expectedBook, book);
    }

    @Test
    public void testListBooks() throws Exception {
        assertEquals("Wrong number of books returned on list all", 221, bookController.listBooks().size());
    }

    @Test
    public void testSearchBooks() throws Exception {
        assertEquals("Wrong number of books returned on search", 8, bookController.searchBooks("öster").size());
    }

    @Test
    public void testListTitles() throws Exception {
        assertEquals("Wrong number of titles returned", 129, bookController.listTitles().size());
    }

    @Test
    public void testListByPublisher() throws Exception {
        assertEquals("Wrong number of titles returned", 24, bookController.listByPublisher(1).size());
    }
}
