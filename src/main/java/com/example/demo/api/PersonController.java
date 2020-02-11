package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

//  define the path
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    //  springboot injects the actual service into this constructor
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //  Method that adds person
    //  we do not wanna return int, just status code thus 'void'
    //  have this method to be served as POST request --> @PostMapping
    //  Tell that we are receiving json payload from the actual body : @RequestBody
    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
//                .orElse(other: null);
               .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id); //  no need to return, since we used void
    }

    @PutMapping(path= "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
