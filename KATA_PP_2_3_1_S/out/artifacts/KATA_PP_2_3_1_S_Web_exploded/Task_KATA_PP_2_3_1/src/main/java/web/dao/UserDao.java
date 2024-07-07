package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void create(User usr);
    List getAllUsers();
    void update(User usr);
    void delete(User usr);
}
