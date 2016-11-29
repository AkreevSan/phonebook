package ru.itpark.service;

import ru.itpark.model.Person;

import java.util.List;

/**
 * Created by Ilsiya on 23.11.2016.
 */
public interface PersonService {
    public void addPerson(Person person);

    public void updatePerson(Person person);

    public void removePerson(int id);

    public Person getPersonById(int id);

    public List<Person> listPerson();
}
