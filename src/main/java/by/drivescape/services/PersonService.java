package by.drivescape.services;

import by.drivescape.dao.PersonDao;
import by.drivescape.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;
    private final HashingService hashingService;

    @Autowired
    public PersonService(PersonDao personDao, HashingService hashingService) {
        System.out.println(PersonService.class);
        this.personDao = personDao;
        this.hashingService = hashingService;
    }

    public void createPerson(Person person) throws MinLengthException {
        String password = person.getPassword();
        if(password.length() < 8) {
            throw new MinLengthException("Length password should be min 8 character");
        }
        person.setPassword(hashingService.getHashString(password));
        personDao.create(person);
    }

    public Person getByIdPerson(Long id) throws SQLException {
        return personDao.getById(id);
    }

    public List<Person> getAllPerson() {
        return personDao.getAll();
    }
}
