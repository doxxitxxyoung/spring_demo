package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    //  make sure to import interface
    //  we need way to distinguish this interface and that of below.
    private final PersonDao personDao;

    //  We are injecting into the actual constructor
    //  we are autowiring the above interface into the below interface
    //  use @Qualifier("mongo") if using mongo db
//    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    //  method to insert a new Person
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    //  Create Method to
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }
}
