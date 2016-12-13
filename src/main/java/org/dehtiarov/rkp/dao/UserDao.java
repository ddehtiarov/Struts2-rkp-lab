package org.dehtiarov.rkp.dao;

import org.dehtiarov.rkp.model.User;

import java.util.List;

public interface UserDao {

    List getAllUsers();

    User getUser(Integer id);

    void update(User emp);

    void insert(User emp);

    void delete(Integer id);

    User getUserByLogin(String login);
}
