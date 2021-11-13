package by.drivescape.services;

import by.drivescape.dao.PersonDAO;
import by.drivescape.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDAO personDAO;
    private final HashingService hashingService;

    @Autowired
    public PersonService(PersonDAO personDAO, HashingService hashingService) {
        this.personDAO = personDAO;
        this.hashingService = hashingService;
    }

    public void createUser(Person person) {
        String password = person.getPassword();
        person.setPassword(hashingService.getHashString(password));
        personDAO.create(person);
    }

}
