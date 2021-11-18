package by.drivescape.preson;

import by.drivescape.TestAppConfig;
import by.drivescape.dao.PersonDao;
import by.drivescape.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.List;

@SpringJUnitWebConfig(TestAppConfig.class)
@ActiveProfiles("test")
public class PersonDaoTests {

    @Autowired
    private PersonDao personDao;

//    @Value("tables.sql")
//    private Resource resource;


    @BeforeEach
    public void setUp(@Autowired DataSource dataSource) {
        Resource resource = new ClassPathResource("tables.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

    @Test
    public void test() {
        List<Person> list = personDao.getAll();
        Assert.notEmpty(list, "List is empty");
    }

}
