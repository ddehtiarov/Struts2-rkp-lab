package org.dehtiarov.rkp.service;

import org.dehtiarov.rkp.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void updateUser(User emp);

    void deletUser(Integer id);

    User getUser(Integer id);

    void insertUser(User emp);

    User getUserByLogin(String login);
}
