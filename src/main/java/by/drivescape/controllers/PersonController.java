package by.drivescape.controllers;

import by.drivescape.dao.PersonDAO;
import by.drivescape.models.Person;
import by.drivescape.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonDAO personDAO;
    private PersonService personService;

    @Autowired
    public PersonController(PersonDAO personDAO, PersonService personService) {
        this.personDAO = personDAO;
        this.personService = personService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersons() {
        return personDAO.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@PathVariable("id") Long id) {
        return personDAO.getById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@Valid Person person) {
        personService.createPerson(person);
    }
}
