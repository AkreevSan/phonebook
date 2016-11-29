package ru.itpark.dao;

import org.hibernate.annotations.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itpark.model.Authorization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorizationDaoImpl implements AuthorizationDao {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Authorization> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Authorization> authorizations = session.createQuery("FROM Authorization").list();

        return authorizations;
    }

    public Authorization get(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        Authorization authorization = (Authorization) session.get(Authorization.class, login);

        return authorization;
    }

    public void add(Authorization authorization) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(authorization);


    }

    public void delete(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        Authorization authorization = (Authorization) session.load(Authorization.class, login);

        if (authorization != null) {
            session.delete(authorization);

        }
    }

    public void edit(Authorization authorization) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(authorization);

    }
}
