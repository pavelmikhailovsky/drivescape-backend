package by.drivescape.controllers;

import by.drivescape.jsonview.MessageExceptionJsonView;
import by.drivescape.models.Person;
import by.drivescape.services.MinLengthException;
import by.drivescape.services.PersonService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@PathVariable("id") Long id) throws SQLException {
        return personService.getByIdPerson(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersons() {
        return personService.getAllPerson();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody Person person) throws MinLengthException {
        personService.createPerson(person);
    }

    @ExceptionHandler({SQLException.class, MinLengthException.class})
    @JsonView(MessageExceptionJsonView.MessageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageExceptionJsonView endpointException(Exception e) {
        return new MessageExceptionJsonView(e.getMessage());
    }
}
