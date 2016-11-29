package ru.itpark.dao;

import ru.itpark.model.Authorization;

import java.util.List;

/**
 * Created by Акреев on 24.11.2016.
 */
public interface AuthorizationDao {

    public List<Authorization> getAll();

    public Authorization get(String login);

    public void add(Authorization authorization);

    public void delete(String login);

    public void edit(Authorization authorization);


}
