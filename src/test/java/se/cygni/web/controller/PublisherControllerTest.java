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

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class PublisherControllerTest {

    @Autowired
    PublisherController publisherController;

    @Configuration
    @ComponentScan("se.cygni.web.controller")
    @PropertySource("classpath:db.properties")
    static class TestContextConfiguration {

        @Autowired
        Environment env;

        @Bean
        public DataSource getDataSource() {

            BasicDataSource ds = new BasicDataSource();
            ds.setUrl(env.getProperty("url"));
            ds.setDriverClassName(env.getProperty("driver"));
            ds.setUsername(env.getProperty("db.user"));
            ds.setPassword(env.getProperty("db.pass"));
            ds.setValidationQueryTimeout(5);
            ds.setValidationQuery("select 1");
            return ds;
        }
    }

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
