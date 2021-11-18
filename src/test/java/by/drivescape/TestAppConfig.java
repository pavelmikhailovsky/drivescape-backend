package by.drivescape;

import by.drivescape.controllers.PersonController;
import by.drivescape.dao.PersonDao;
import by.drivescape.services.HashingService;
import by.drivescape.services.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
public class TestAppConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new MappingJackson2JsonView());
    }

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        driverManagerDataSource.setUsername("sa");
        driverManagerDataSource.setPassword("sa");
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public HashingService hashingService() {
        return new HashingService();
    }

    @Bean
    public PersonDao personDao() {
        return new PersonDao(jdbcTemplate());
    }

    @Bean
    public PersonService personService() {
        return new PersonService(personDao(), hashingService());
    }

    @Bean
    public PersonController personController() {
        return new PersonController(personService());
    }

}
