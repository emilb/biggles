package se.cygni.web.controller;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.sql.DataSource;

@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class SpringBaseTest {

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
}
