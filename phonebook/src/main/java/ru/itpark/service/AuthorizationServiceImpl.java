package ru.itpark.service;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Proxy;
import ru.itpark.dao.AuthorizationDao;
import ru.itpark.model.Authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private AuthorizationDao authorizationDao;


    @Autowired
    public void setAuthorizationDao(AuthorizationDao authorizationDao) {
        this.authorizationDao = authorizationDao;
    }

    @Transactional
    public List<Authorization> getAll() {
        return this.authorizationDao.getAll();
    }


    @Transactional
    public Authorization get(String login) {
        return this.authorizationDao.get(login);
    }

    @Transactional
    public void add(Authorization authorization) {
        this.authorizationDao.add(authorization);
    }

    @Transactional
    public void delete(String login) {
        this.authorizationDao.delete(login);
    }

    @Transactional
    public void edit(Authorization authorization) {
        this.authorizationDao.edit(authorization);
    }
}
