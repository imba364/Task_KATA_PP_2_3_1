package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

        void create(User user);
        List getAllUsers();
        void update(User usr);
        void delete(User usr);
    }
