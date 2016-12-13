package org.dehtiarov.rkp.dao;

import org.dehtiarov.rkp.model.Role;
import org.dehtiarov.rkp.model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {

    private static List<User> users;

    static {
        users = new ArrayList<User>();
        users.add(new User(1, 36, "Artem R", "artem@gmail.com", "artemon", "artem12345", Role.USER));
        users.add(new User(2, 36, "admin", "admin@gmail.com", "admin12", "admin12", Role.ADMIN));
        users.add(new User(3, 36, "user 123", "user@gmail.com", "user12", "user12", Role.USER));
    }

    @Override
    public List getAllUsers() {
        return users;
    }

    @Override
    public User getUser(Integer id) {
        User emp = null;
        for (User user : users) {
            emp = user;
            if (emp.getEmployeeId().equals(id)) {
                break;
            }
        }
        return emp;
    }

    @Override
    public void update(User emp) {
        Integer id = emp.getEmployeeId();
        for (int i = 0; i < users.size(); i++) {
            User tempEmp = users.get(i);
            if (tempEmp.getEmployeeId().equals(id)) {
                users.set(i, emp);
                break;
            }
        }
    }

    @Override
    public void insert(User emp) {
        int lastId = 0;
        for (User temp : users) {
            if (temp.getEmployeeId() > lastId) {
                lastId = temp.getEmployeeId();
            }
        }
        emp.setEmployeeId(lastId + 1);
        users.add(emp);
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i < users.size(); i++) {
            User tempEmp = users.get(i);
            if (tempEmp.getEmployeeId().equals(id)) {
                users.remove(i);
                break;
            }
        }
    }

    @Override
    public User getUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny().orElse(null);
    }

}
