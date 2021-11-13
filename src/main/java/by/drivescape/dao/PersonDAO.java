package by.drivescape.dao;

import by.drivescape.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAll() {
        return jdbcTemplate.queryForList("SELECT * FROM person ORDER BY person_id DESC", Person.class);
    }

    public Person getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE person_id=?", Person.class, id);
    }

    public void create(Person person) {
        jdbcTemplate.update(
                "INSERT INTO person(first_name, last_name, password, email) VALUES (?, ?, ?, ?)",
                person.getFirstName(), person.getLastName(), person.getPassword(), person.getEmail()
        );
    }

}
