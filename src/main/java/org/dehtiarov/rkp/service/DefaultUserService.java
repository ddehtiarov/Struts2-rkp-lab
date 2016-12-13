package org.dehtiarov.rkp.service;

import org.dehtiarov.rkp.dao.UserDao;
import org.dehtiarov.rkp.dao.InMemoryUserDao;
import org.dehtiarov.rkp.model.User;

import java.util.List;

public class DefaultUserService implements UserService {

    private UserDao dao;

    public DefaultUserService() {
        this.dao = new InMemoryUserDao();
    }

    @Override
    public List getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void updateUser(User emp) {
        dao.update(emp);
    }

    @Override
    public void deletUser(Integer id) {
        dao.delete(id);
    }

    @Override
    public User getUser(Integer id) {
        return dao.getUser(id);
    }

    @Override
    public void insertUser(User emp) {
        dao.insert(emp);
    }

    @Override
    public User getUserByLogin(String login) {
        return dao.getUserByLogin(login);
    }
}
