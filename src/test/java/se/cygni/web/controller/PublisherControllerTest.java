package se.cygni.web.controller;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import se.cygni.web.model.Publisher;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class PublisherControllerTest extends SpringBaseTest {

    @Autowired
    PublisherController publisherController;

    @Test
    public void testListPublishers() throws Exception {
        List<Publisher> publisherList = publisherController.listPublishers();
        assertEquals("Wrong number of publishers returned", 16, publisherList.size());
    }

    @Test
    public void testById() throws Exception {
        Publisher publisher = publisherController.byId(6);
        assertEquals("Wrong id", 6, publisher.id);
        assertEquals("Wrong name", "B Wahlströms ungdomspocket", publisher.name);
        assertEquals("Wrong short name", "BW pock", publisher.shortName);
        assertEquals("Wrong slug name", "b-wahlstroms-ungdomspocket", publisher.nameSlug);
    }
}
