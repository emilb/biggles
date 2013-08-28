package se.cygni.web.init;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;


@Configuration
@ComponentScan("se.cygni.web.controller")
@EnableWebMvc
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class WebappConfig extends WebMvcConfigurerAdapter {

    @Autowired
    Environment env;


    //Tell SpringMVC where to find view scripts
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    //Enable serving static resources even when DispatcherServlet is mapped to /
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //Set up dataSource to be used by Hibernate. Also make sure the connection doesn't go down
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