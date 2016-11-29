package ru.itpark.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.itpark.model.Person;

import java.util.List;

/**
 * Created by Ilsiya on 23.11.2016.
 */
@Repository
public class PersonDaoImpl implements PersonDao {
    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
        logger.info("Person successfully saved. Person details:" + person);
    }

    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
        logger.info("Person successfully update. Person details:" + person);

    }

    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));

        if (person != null) {
            session.delete(person);
        }
        logger.info("Person successfully removed. Person details:" + person);
    }

    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person successfully loaded. Person details:" + person);

        return person;
    }

    public List<Person> listPerson() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("FROM Person").list();

        for (Person person : personList) {
            logger.info("Person list:" + person);
        }
        return personList;
    }
}
