package org.dehtiarov.rkp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.commons.lang3.StringUtils;
import org.dehtiarov.rkp.model.Role;
import org.dehtiarov.rkp.model.User;
import org.dehtiarov.rkp.service.DefaultUserService;
import org.dehtiarov.rkp.service.UserService;

import java.util.List;
import java.util.Objects;

public class UserAction extends ActionSupport implements Preparable {

    public static final String CURRENT_USER = "currentUser";
    private UserService empService = new DefaultUserService();

    private User user;
    private User currentUser;
    private List users;

    @Override
    public void prepare() throws Exception {
        if (user != null && user.getEmployeeId() != null) {
            user = empService.getUser(user.getEmployeeId());
        }
        Object userSession = ActionContext.getContext().getSession().get(CURRENT_USER);
        if (Objects.nonNull(userSession)) {
            currentUser = (User) userSession;
        }
    }

    public String save() {
        validate();
        if (user.getEmployeeId() == null) {
            empService.insertUser(user);
        } else {
            empService.updateUser(user);
        }
        return SUCCESS;
    }

    public String start() {
        if (user != null && StringUtils.isNotBlank(user.getLogin()) && StringUtils.isNotBlank(user.getPassword())) {
            User userByLogin = empService.getUserByLogin(user.getLogin());
            if (Objects.nonNull(userByLogin) && userByLogin.getPassword().equals(user.getPassword())) {
                currentUser = userByLogin;
                ActionContext.getContext().getSession().put(CURRENT_USER, userByLogin);
                return SUCCESS;
            }
        }
        return LOGIN;
    }

    public String goaway() {
        ActionContext.getContext().getSession().put(CURRENT_USER, null);
        return LOGIN;
    }

    public String register() {
        validate();
        if (user != null && StringUtils.isNotBlank(user.getLogin()) && Objects.isNull(empService.getUserByLogin(user.getLogin()))) {
            user.setRole(Role.USER);
            empService.insertUser(user);
            currentUser = user;
            ActionContext.getContext().getSession().put(CURRENT_USER, currentUser);
            return SUCCESS;
        }
        return INPUT;
    }

    public String delete() {
        empService.deletUser(user.getEmployeeId());
        return SUCCESS;
    }

    public String list() {
        if (Objects.isNull(currentUser)) {
            return LOGIN;
        }
        users = empService.getAllUsers();
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List getUsers() {
        return users;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
