package by.drivescape.dao;

import by.drivescape.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDAO implements DataAccessObject<Person> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println(PersonDAO.class);
    }

    public List<Person> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM person ORDER BY person_id DESC",
                new BeanPropertyRowMapper<>(Person.class)
        );
    }

    public Person getById(Long id) throws SQLException {
        return jdbcTemplate.query(
                "SELECT * FROM person WHERE person_id=?",
                new BeanPropertyRowMapper<>(Person.class),
                id
        ).stream().findAny().orElseThrow(() -> new SQLException("Person is not find by id"));
    }

    public void create(Person person) {
         jdbcTemplate.update(
                "INSERT INTO person(first_name, last_name, password, email) VALUES (?, ?, ?, ?)",
                person.getFirstName(), person.getLastName(), person.getPassword(), person.getEmail()
        );
    }

}
