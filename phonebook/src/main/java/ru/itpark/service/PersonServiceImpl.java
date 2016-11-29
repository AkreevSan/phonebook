package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.dao.PersonDao;
import ru.itpark.model.Person;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    public void addPerson(Person person) {
        this.personDao.addPerson(person);

    }

    @Transactional
    public void updatePerson(Person person) {
        this.personDao.updatePerson(person);

    }

    @Transactional
    public void removePerson(int id) {
        this.personDao.removePerson(id);
    }

    @Transactional
    public Person getPersonById(int id) {
        return this.personDao.getPersonById(id);
    }

    @Transactional
    public List<Person> listPerson() {
        return this.personDao.listPerson();
    }
}
